package com.arthenica.ffmpegkit;

import java.util.List;
import java.util.ArrayList;

/**
 * Media information session.
 */
public class MediaInformationSession extends Session {
    public MediaInformationSession() {
        // Default constructor
    }
    
    public MediaInformationSession(String command) {
        // Constructor with command
    }
    
    public MediaInformationSession(String command, ExecuteCallback executeCallback) {
        // Constructor with command and execute callback
    }
    
    public MediaInformationSession(String command, ExecuteCallback executeCallback, LogCallback logCallback) {
        // Constructor with command, execute callback, and log callback
    }
    
    public static MediaInformationSession create(String[] arguments, ExecuteCallback executeCallback, LogCallback logCallback) {
        return new MediaInformationSession();
    }
    
    public MediaInformation getMediaInformation() {
        return new MediaInformation();
    }
}