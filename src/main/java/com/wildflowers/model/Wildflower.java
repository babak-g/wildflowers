package com.wildflowers.model;

import java.time.LocalDate;

public class Wildflower {
    private Integer wildflowerId;
    private String commonName;
    private String scientificName;
    private Integer colorId;
    private Integer zoneId;
    private LocalDate bloomStartDate;
    private LocalDate bloomEndDate;
    private String imageUrl;
    
    // Constructors
    public Wildflower() {}
    
    public Wildflower(Integer wildflowerId, String commonName, String scientificName,
                     Integer colorId, Integer zoneId, LocalDate bloomStartDate,
                     LocalDate bloomEndDate, String imageUrl) {
        this.wildflowerId = wildflowerId;
        this.commonName = commonName;
        this.scientificName = scientificName;
        this.colorId = colorId;
        this.zoneId = zoneId;
        this.bloomStartDate = bloomStartDate;
        this.bloomEndDate = bloomEndDate;
        this.imageUrl = imageUrl;
    }
    
    // Getters and Setters
    public Integer getWildflowerId() { return wildflowerId; }
    public void setWildflowerId(Integer wildflowerId) { this.wildflowerId = wildflowerId; }
    
    public String getCommonName() { return commonName; }
    public void setCommonName(String commonName) { this.commonName = commonName; }
    
    public String getScientificName() { return scientificName; }
    public void setScientificName(String scientificName) { this.scientificName = scientificName; }
    
    public Integer getColorId() { return colorId; }
    public void setColorId(Integer colorId) { this.colorId = colorId; }
    
    public Integer getZoneId() { return zoneId; }
    public void setZoneId(Integer zoneId) { this.zoneId = zoneId; }
    
    public LocalDate getBloomStartDate() { return bloomStartDate; }
    public void setBloomStartDate(LocalDate bloomStartDate) { this.bloomStartDate = bloomStartDate; }
    
    public LocalDate getBloomEndDate() { return bloomEndDate; }
    public void setBloomEndDate(LocalDate bloomEndDate) { this.bloomEndDate = bloomEndDate; }
    
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
}