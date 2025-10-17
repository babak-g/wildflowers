package com.wildflowers.model;

public class ElevationalZone {
    private Integer zoneId;
    private String name;
    
    public ElevationalZone() {}
    
    public ElevationalZone(Integer zoneId, String name) {
        this.zoneId = zoneId;
        this.name = name;
    }
    
    public Integer getZoneId() { return zoneId; }
    public void setZoneId(Integer zoneId) { this.zoneId = zoneId; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}