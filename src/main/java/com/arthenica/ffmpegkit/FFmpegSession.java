package com.arthenica.ffmpegkit;

import java.util.List;

/**
 * FFmpeg session.
 */
public class FFmpegSession extends Session {
    public FFmpegSession() {
        // Default constructor
    }
    
    public FFmpegSession(String command) {
        // Constructor with command
    }
    
    public FFmpegSession(String command, ExecuteCallback executeCallback) {
        // Constructor with command and execute callback
    }
    
    public FFmpegSession(String command, ExecuteCallback executeCallback, LogCallback logCallback) {
        // Constructor with command, execute callback, and log callback
    }
    
    public FFmpegSession(String command, ExecuteCallback executeCallback, LogCallback logCallback, StatisticsCallback statisticsCallback) {
        // Constructor with command, execute callback, log callback, and statistics callback
    }
    
    public static FFmpegSession create(String[] arguments, ExecuteCallback executeCallback, LogCallback logCallback, StatisticsCallback statisticsCallback, LogRedirectionStrategy logRedirectionStrategy) {
        return new FFmpegSession();
    }
    
    public List<Statistics> getAllStatistics(int timeout) {
        return new ArrayList<>();
    }
    
    public List<Statistics> getStatistics() {
        return new ArrayList<>();
    }
}