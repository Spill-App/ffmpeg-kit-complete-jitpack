package com.arthenica.ffmpegkit;

/**
 * Statistics for an FFmpeg session.
 */
public class Statistics {
    private long sessionId;
    private int videoFrameNumber;
    private float videoFps;
    private float videoQuality;
    private long size;
    private long time;
    private double bitrate;
    private double speed;
    
    public long getSessionId() {
        return sessionId;
    }
    
    public int getVideoFrameNumber() {
        return videoFrameNumber;
    }
    
    public float getVideoFps() {
        return videoFps;
    }
    
    public float getVideoQuality() {
        return videoQuality;
    }
    
    public long getSize() {
        return size;
    }
    
    public long getTime() {
        return time;
    }
    
    public double getBitrate() {
        return bitrate;
    }
    
    public double getSpeed() {
        return speed;
    }
}