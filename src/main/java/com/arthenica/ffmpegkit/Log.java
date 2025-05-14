package com.arthenica.ffmpegkit;

/**
 * Log entry for an FFmpeg session.
 */
public class Log {
    private String message;
    private Level level;
    private long sessionId;
    
    public Log(String message) {
        this.message = message;
    }
    
    public String getMessage() {
        return message;
    }
    
    public Level getLevel() {
        return level;
    }
    
    public long getSessionId() {
        return sessionId;
    }
}