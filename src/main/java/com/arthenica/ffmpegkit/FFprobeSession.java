package com.arthenica.ffmpegkit;

import java.util.List;
import java.util.ArrayList;

/**
 * FFprobe session.
 */
public class FFprobeSession extends Session {
    public FFprobeSession() {
        // Default constructor
    }
    
    public FFprobeSession(String command) {
        // Constructor with command
    }
    
    public FFprobeSession(String command, ExecuteCallback executeCallback) {
        // Constructor with command and execute callback
    }
    
    public FFprobeSession(String command, ExecuteCallback executeCallback, LogCallback logCallback) {
        // Constructor with command, execute callback, and log callback
    }
    
    public static FFprobeSession create(String[] arguments, ExecuteCallback executeCallback, LogCallback logCallback, LogRedirectionStrategy logRedirectionStrategy) {
        return new FFprobeSession();
    }
}