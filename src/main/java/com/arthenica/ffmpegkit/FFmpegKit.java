package com.arthenica.ffmpegkit;

import java.util.List;
import java.util.ArrayList;

public class FFmpegKit {
    public static void cancel() {}
    
    public static void cancel(long sessionId) {}
    
    public static List<Session> listSessions() {
        return new ArrayList<>();
    }
}