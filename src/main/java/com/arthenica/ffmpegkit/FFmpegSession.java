package com.arthenica.ffmpegkit;

import java.util.List;
import java.util.ArrayList;

/**
 * FFmpeg session.
 */
public class FFmpegSession extends Session {
    public FFmpegSession() {
        super();
        setSessionType(SessionType.FFMPEG);
    }
    
    public FFmpegSession(String command) {
        super();
        this.command = command;
        setSessionType(SessionType.FFMPEG);
    }
    
    public FFmpegSession(String command, ExecuteCallback executeCallback) {
        super();
        this.command = command;
        setSessionType(SessionType.FFMPEG);
    }
    
    public FFmpegSession(String command, ExecuteCallback executeCallback, LogCallback logCallback) {
        super();
        this.command = command;
        this.logCallback = logCallback;
        setSessionType(SessionType.FFMPEG);
    }
    
    public FFmpegSession(String command, ExecuteCallback executeCallback, LogCallback logCallback, StatisticsCallback statisticsCallback) {
        super();
        this.command = command;
        this.logCallback = logCallback;
        setSessionType(SessionType.FFMPEG);
    }
    
    public static FFmpegSession create(String[] arguments, ExecuteCallback executeCallback, LogCallback logCallback, StatisticsCallback statisticsCallback, LogRedirectionStrategy logRedirectionStrategy) {
        FFmpegSession session = new FFmpegSession();
        session.command = String.join(" ", arguments);
        
        // Store the session immediately upon creation
        FFmpegKitConfig.addSession(session);
        
        System.out.println("FFmpegSession.create: Created and stored session " + session.getSessionId());
        
        return session;
    }
    
    public List<Statistics> getAllStatistics(int timeout) {
        return new ArrayList<>();
    }
    
    public List<Statistics> getStatistics() {
        return new ArrayList<>();
    }
    
    @Override
    public boolean isFFmpeg() {
        return true;
    }
}