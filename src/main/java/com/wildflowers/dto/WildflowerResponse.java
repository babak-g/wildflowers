package com.wildflowers.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WildflowerResponse {
    @JsonProperty("wildflower_id")
    private Integer wildflowerId;
    
    @JsonProperty("common_name")
    private String commonName;
    
    @JsonProperty("scientific_name")
    private String scientificName;
    
    @JsonProperty("color")
    private String color;
    
    @JsonProperty("elevational_zone")
    private String elevationalZone;
    
    @JsonProperty("bloom_start_date")
    private String bloomStartDate;
    
    @JsonProperty("bloom_end_date")
    private String bloomEndDate;
    
    @JsonProperty("image_url")
    private String imageUrl;
    
    // Constructors
    public WildflowerResponse() {}
    
    // Builder-style constructor for clarity
    public static class Builder {
        private WildflowerResponse response = new WildflowerResponse();
        
        public Builder wildflowerId(Integer id) {
            response.wildflowerId = id;
            return this;
        }
        
        public Builder commonName(String name) {
            response.commonName = name;
            return this;
        }
        
        public Builder scientificName(String name) {
            response.scientificName = name;
            return this;
        }
        
        public Builder color(String color) {
            response.color = color;
            return this;
        }
        
        public Builder elevationalZone(String zone) {
            response.elevationalZone = zone;
            return this;
        }
        
        public Builder bloomStartDate(String date) {
            response.bloomStartDate = date;
            return this;
        }
        
        public Builder bloomEndDate(String date) {
            response.bloomEndDate = date;
            return this;
        }
        
        public Builder imageUrl(String url) {
            response.imageUrl = url;
            return this;
        }
        
        public WildflowerResponse build() {
            return response;
        }
    }
    
    public static Builder builder() {
        return new Builder();
    }
    
    // Getters
    public Integer getWildflowerId() { return wildflowerId; }
    public String getCommonName() { return commonName; }
    public String getScientificName() { return scientificName; }
    public String getColor() { return color; }
    public String getElevationalZone() { return elevationalZone; }
    public String getBloomStartDate() { return bloomStartDate; }
    public String getBloomEndDate() { return bloomEndDate; }
    public String getImageUrl() { return imageUrl; }
}