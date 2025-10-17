package com.wildflowers.controller;

import com.wildflowers.dto.WildflowerResponse;
import com.wildflowers.dto.WildflowersListResponse;
import com.wildflowers.service.WildflowerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wildflowers")
public class WildflowerController {
    
    private final WildflowerService service;
    
    public WildflowerController(WildflowerService service) {
        this.service = service;
    }
    
    /**
     * GET /wildflowers
     * Returns all wildflowers, optionally filtered by color, zone, or scientific_name
     */
    @GetMapping
    public ResponseEntity<WildflowersListResponse> getWildflowers(
            @RequestParam(required = false) String color,
            @RequestParam(required = false) String zone,
            @RequestParam(name = "scientific_name", required = false) String scientificName) {
        
        WildflowersListResponse response = service.getWildflowers(color, zone, scientificName);
        return ResponseEntity.ok(response);
    }
    
    /**
     * GET /wildflowers/:id
     * Returns details for a single wildflower
     */
    @GetMapping("/{id}")
    public ResponseEntity<WildflowerResponse> getWildflowerById(@PathVariable Integer id) {
        return service.getWildflowerById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
}