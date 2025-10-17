package com.wildflowers.model;

public class Color {
    private Integer colorId;
    private String name;
    
    public Color() {}
    
    public Color(Integer colorId, String name) {
        this.colorId = colorId;
        this.name = name;
    }
    
    public Integer getColorId() { return colorId; }
    public void setColorId(Integer colorId) { this.colorId = colorId; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}