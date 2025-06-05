package com.arthenica.ffmpegkit;

/**
 * FFprobe session.
 */
public class FFprobeSession extends Session {
    public FFprobeSession() {
        super();
        setSessionType(SessionType.FFPROBE);
    }
    
    public FFprobeSession(String command) {
        super();
        this.command = command;
        setSessionType(SessionType.FFPROBE);
    }
    
    public FFprobeSession(String command, ExecuteCallback executeCallback) {
        super();
        this.command = command;
        setSessionType(SessionType.FFPROBE);
    }
    
    public FFprobeSession(String command, ExecuteCallback executeCallback, LogCallback logCallback) {
        super();
        this.command = command;
        this.logCallback = logCallback;
        setSessionType(SessionType.FFPROBE);
    }
    
    public static FFprobeSession create(String[] arguments, ExecuteCallback executeCallback, LogCallback logCallback, LogRedirectionStrategy logRedirectionStrategy) {
        return new FFprobeSession();
    }
    
    @Override
    public boolean isFFprobe() {
        return true;
    }
}