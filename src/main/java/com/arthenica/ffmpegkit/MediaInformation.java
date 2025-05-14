package com.arthenica.ffmpegkit;

import org.json.JSONObject;

/**
 * Media information class.
 */
public class MediaInformation {
    private JSONObject allProperties;
    
    public JSONObject getAllProperties() {
        if (allProperties == null) {
            allProperties = new JSONObject();
        }
        return allProperties;
    }
}