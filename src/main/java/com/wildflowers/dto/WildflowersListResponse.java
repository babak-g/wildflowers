package com.wildflowers.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class WildflowersListResponse {
    @JsonProperty("wildflowers")
    private List<WildflowerResponse> wildflowers;
    
    @JsonProperty("total_count")
    private int totalCount;
    
    public WildflowersListResponse(List<WildflowerResponse> wildflowers) {
        this.wildflowers = wildflowers;
        this.totalCount = wildflowers.size();
    }
    
    public List<WildflowerResponse> getWildflowers() { return wildflowers; }
    public int getTotalCount() { return totalCount; }
}
