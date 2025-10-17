package com.wildflowers.repository;

import com.wildflowers.model.Wildflower;
import com.wildflowers.model.Color;
import com.wildflowers.model.ElevationalZone;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class WildflowerRepository {
    
    private final Map<Integer, Wildflower> wildflowers = new HashMap<>();
    private final Map<Integer, Color> colors = new HashMap<>();
    private final Map<Integer, ElevationalZone> zones = new HashMap<>();
    
    public WildflowerRepository() {
        initializeData();
    }
    
    private void initializeData() {
        // Initialize colors
        colors.put(1, new Color(1, "blue"));
        colors.put(2, new Color(2, "yellow"));
        colors.put(3, new Color(3, "white"));
        colors.put(4, new Color(4, "pink"));
        colors.put(5, new Color(5, "red"));
        
        // Initialize zones
        zones.put(1, new ElevationalZone(1, "lowland"));
        zones.put(2, new ElevationalZone(2, "montane"));
        zones.put(3, new ElevationalZone(3, "subalpine"));
        zones.put(4, new ElevationalZone(4, "alpine"));
        
        // Initialize wildflowers with Mt. Rainier species
        wildflowers.put(1, new Wildflower(
            1, "Subalpine Lupine", "Lupinus arcticus",
            1, 3, LocalDate.of(2024, 7, 1), LocalDate.of(2024, 8, 31),
            "https://example.com/lupine.jpg"
        ));
        
        wildflowers.put(2, new Wildflower(
            2, "Glacier Lily", "Erythronium grandiflorum",
            2, 3, LocalDate.of(2024, 6, 15), LocalDate.of(2024, 7, 31),
            "https://example.com/glacier-lily.jpg"
        ));
        
        wildflowers.put(3, new Wildflower(
            3, "Avalanche Lily", "Erythronium montanum",
            3, 3, LocalDate.of(2024, 6, 1), LocalDate.of(2024, 8, 15),
            "https://example.com/avalanche-lily.jpg"
        ));
        
        wildflowers.put(4, new Wildflower(
            4, "Broadleaf Lupine", "Lupinus latifolius",
            1, 2, LocalDate.of(2024, 6, 1), LocalDate.of(2024, 8, 31),
            "https://example.com/broadleaf-lupine.jpg"
        ));
        
        wildflowers.put(5, new Wildflower(
            5, "Magenta Paintbrush", "Castilleja parviflora",
            4, 3, LocalDate.of(2024, 7, 15), LocalDate.of(2024, 9, 1),
            "https://example.com/paintbrush.jpg"
        ));
    }
    
    public Optional<Wildflower> findById(Integer id) {
        return Optional.ofNullable(wildflowers.get(id));
    }
    
    public List<Wildflower> findAll() {
        return new ArrayList<>(wildflowers.values());
    }
    
    public List<Wildflower> findByFilters(String color, String zone, String scientificName) {
        return wildflowers.values().stream()
            .filter(w -> matchesColorFilter(w, color))
            .filter(w -> matchesZoneFilter(w, zone))
            .filter(w -> matchesScientificNameFilter(w, scientificName))
            .collect(Collectors.toList());
    }
    
    private boolean matchesColorFilter(Wildflower w, String color) {
        if (color == null || color.isEmpty()) return true;
        Color c = colors.get(w.getColorId());
        return c != null && c.getName().equalsIgnoreCase(color);
    }
    
    private boolean matchesZoneFilter(Wildflower w, String zone) {
        if (zone == null || zone.isEmpty()) return true;
        ElevationalZone z = zones.get(w.getZoneId());
        return z != null && z.getName().equalsIgnoreCase(zone);
    }
    
    private boolean matchesScientificNameFilter(Wildflower w, String scientificName) {
        if (scientificName == null || scientificName.isEmpty()) return true;
        return w.getScientificName().toLowerCase().contains(scientificName.toLowerCase());
    }
    
    public Optional<Color> getColorById(Integer colorId) {
        return Optional.ofNullable(colors.get(colorId));
    }
    
    public Optional<ElevationalZone> getZoneById(Integer zoneId) {
        return Optional.ofNullable(zones.get(zoneId));
    }
}