package org.json;

import java.util.HashMap;
import java.util.Map;

/**
 * Simplified JSONObject implementation for stubs.
 */
public class JSONObject {
    private final Map<String, Object> map = new HashMap<>();
    
    public JSONObject() {
        // Default constructor
    }
    
    public Object get(String key) {
        return map.get(key);
    }
    
    public JSONObject put(String key, Object value) {
        map.put(key, value);
        return this;
    }
    
    @Override
    public String toString() {
        return map.toString();
    }
}