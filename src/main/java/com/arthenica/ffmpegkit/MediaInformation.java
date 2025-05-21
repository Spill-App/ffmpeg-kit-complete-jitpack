package com.arthenica.ffmpegkit;

import java.util.HashMap;
import java.util.Map;

/**
 * Media information class.
 */
public class MediaInformation {
    // Use Map<String, Object> instead of JSONObject
    private Map<String, Object> allProperties;
    
    /**
     * Get all properties.
     * 
     * @return Map containing all properties
     */
    public Map<String, Object> getAllProperties() {
        if (allProperties == null) {
            allProperties = new HashMap<>();
        }
        return allProperties;
    }
}