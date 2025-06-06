package com.arthenica.ffmpegkit;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Base session class.
 */
public class Session {
    private static final AtomicLong sessionIdCounter = new AtomicLong(1);
    
    protected String command;
    protected ReturnCode returnCode;
    protected SessionState state;
    protected LogCallback logCallback;
    protected long sessionId;
    protected Date createTime;
    protected Date startTime;
    protected Date endTime;
    protected SessionType sessionType;
    
    // Constructor
    public Session() {
        this.sessionId = sessionIdCounter.getAndIncrement();
        this.createTime = new Date();
        this.sessionType = SessionType.UNKNOWN;
        this.state = SessionState.CREATED;
        System.out.println("Session created: ID=" + sessionId + ", Type=" + getClass().getSimpleName());
    }
    
    public String getCommand() {
        return command;
    }
    
    public ReturnCode getReturnCode() {
        return returnCode;
    }
    
    public SessionState getState() {
        return state;
    }
    
    public List<Log> getLogs() {
        return new ArrayList<>();
    }
    
    public Date getEndTime() {
        return endTime;
    }
    
    public long getDuration() {
        return 0;
    }
    
    public List<Log> getAllLogs(int timeout) {
        return new ArrayList<>();
    }
    
    public String getAllLogsAsString(int timeout) {
        return "";
    }
    
    public String getFailStackTrace() {
        return "";
    }
    
    public boolean thereAreAsynchronousMessagesInTransmit() {
        return false;
    }
    
    // These methods should return the correct type based on the actual session type
    public boolean isFFmpeg() {
        return this instanceof FFmpegSession || sessionType == SessionType.FFMPEG;
    }
    
    public boolean isFFprobe() {
        return this instanceof FFprobeSession || sessionType == SessionType.FFPROBE;
    }
    
    public boolean isMediaInformation() {
        return this instanceof MediaInformationSession || sessionType == SessionType.MEDIA_INFORMATION;
    }
    
    public LogCallback getLogCallback() {
        return logCallback;
    }
    
    public long getSessionId() {
        return sessionId;
    }
    
    public Date getCreateTime() {
        return createTime;
    }
    
    public Date getStartTime() {
        return startTime;
    }
    
    // Protected method to set session type
    protected void setSessionType(SessionType type) {
        this.sessionType = type;
    }
}