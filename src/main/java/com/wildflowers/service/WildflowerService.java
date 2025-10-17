package com.wildflowers.service;

import com.wildflowers.dto.WildflowerResponse;
import com.wildflowers.dto.WildflowersListResponse;
import com.wildflowers.model.Wildflower;
import com.wildflowers.model.Color;
import com.wildflowers.model.ElevationalZone;
import com.wildflowers.repository.WildflowerRepository;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WildflowerService {
    
    private final WildflowerRepository repository;
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("MMMM d");
    
    public WildflowerService(WildflowerRepository repository) {
        this.repository = repository;
    }
    
    public WildflowersListResponse getWildflowers(String color, String zone, String scientificName) {
        List<Wildflower> wildflowers = repository.findByFilters(color, zone, scientificName);
        List<WildflowerResponse> responses = wildflowers.stream()
            .map(this::toResponse)
            .collect(Collectors.toList());
        return new WildflowersListResponse(responses);
    }
    
    public Optional<WildflowerResponse> getWildflowerById(Integer id) {
        return repository.findById(id).map(this::toResponse);
    }
    
    private WildflowerResponse toResponse(Wildflower wildflower) {
        String colorName = repository.getColorById(wildflower.getColorId())
            .map(Color::getName)
            .orElse("unknown");
        
        String zoneName = repository.getZoneById(wildflower.getZoneId())
            .map(ElevationalZone::getName)
            .orElse("unknown");
        
        return WildflowerResponse.builder()
            .wildflowerId(wildflower.getWildflowerId())
            .commonName(wildflower.getCommonName())
            .scientificName(wildflower.getScientificName())
            .color(colorName)
            .elevationalZone(zoneName)
            .bloomStartDate(wildflower.getBloomStartDate().format(DATE_FORMATTER))
            .bloomEndDate(wildflower.getBloomEndDate().format(DATE_FORMATTER))
            .imageUrl(wildflower.getImageUrl())
            .build();
    }
}