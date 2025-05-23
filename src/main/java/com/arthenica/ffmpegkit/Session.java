package com.arthenica.ffmpegkit;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

/**
 * Base session class.
 */
public class Session {
    protected String command;
    protected ReturnCode returnCode;
    protected SessionState state;
    protected LogCallback logCallback;
    protected long sessionId;
    protected Date createTime;
    protected Date startTime;
    protected Date endTime;
    
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
    
    public boolean isFFmpeg() {
        return false;
    }
    
    public boolean isFFprobe() {
        return false;
    }
    
    public boolean isMediaInformation() {
        return false;
    }
    
    public LogCallback getLogCallback() {
        return logCallback;
    }
    
    // New methods
    public long getSessionId() {
        return sessionId;
    }
    
    public Date getCreateTime() {
        return createTime;
    }
    
    public Date getStartTime() {
        return startTime;
    }
}