package com.arthenica.ffmpegkit;

/**
 * Media information session.
 */
public class MediaInformationSession extends Session {
    public MediaInformationSession() {
        super();
        setSessionType(SessionType.MEDIA_INFORMATION);
    }
    
    public MediaInformationSession(String command) {
        super();
        this.command = command;
        setSessionType(SessionType.MEDIA_INFORMATION);
    }
    
    public MediaInformationSession(String command, ExecuteCallback executeCallback) {
        super();
        this.command = command;
        setSessionType(SessionType.MEDIA_INFORMATION);
    }
    
    public MediaInformationSession(String command, ExecuteCallback executeCallback, LogCallback logCallback) {
        super();
        this.command = command;
        this.logCallback = logCallback;
        setSessionType(SessionType.MEDIA_INFORMATION);
    }
    
    public static MediaInformationSession create(String[] arguments, ExecuteCallback executeCallback, LogCallback logCallback) {
        return new MediaInformationSession();
    }
    
    public MediaInformation getMediaInformation() {
        return new MediaInformation();
    }
    
    @Override
    public boolean isMediaInformation() {
        return true;
    }
}