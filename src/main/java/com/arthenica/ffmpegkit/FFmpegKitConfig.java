package com.arthenica.ffmpegkit;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.ConcurrentHashMap;

/**
 * FFmpeg Kit configuration.
 */
public class FFmpegKitConfig {
    private static final AtomicLong sessionIdCounter = new AtomicLong(1);
    // Use ConcurrentHashMap for thread safety
    private static final Map<Long, Session> sessions = new ConcurrentHashMap<>();
    
    // Session management methods
    public static Session getSession(long sessionId) {
        Session session = sessions.get(sessionId);
        System.out.println("FFmpegKitConfig.getSession(" + sessionId + ") = " + (session != null ? session.getClass().getSimpleName() : "null"));
        return session;
    }
    
    public static void addSession(Session session) {
        if (session != null) {
            sessions.put(session.getSessionId(), session);
            System.out.println("FFmpegKitConfig.addSession: Added session " + session.getSessionId() + " of type " + session.getClass().getSimpleName());
        }
    }
    
    // Make sure sessions are created and stored when these methods are called
    public static void asyncFFmpegExecute(FFmpegSession session) {
        System.out.println("FFmpegKitConfig.asyncFFmpegExecute: FFmpegSession " + session.getSessionId());
        addSession(session);
    }
    
    public static void asyncFFmpegExecute(Session session) {
        System.out.println("FFmpegKitConfig.asyncFFmpegExecute: Session " + session.getSessionId());
        addSession(session);
    }
    
    public static void asyncFFprobeExecute(FFprobeSession session) {
        System.out.println("FFmpegKitConfig.asyncFFprobeExecute: FFprobeSession " + session.getSessionId());
        addSession(session);
    }
    
    public static void asyncFFprobeExecute(Session session) {
        System.out.println("FFmpegKitConfig.asyncFFprobeExecute: Session " + session.getSessionId());
        addSession(session);
    }
    
    public static void asyncGetMediaInformationExecute(MediaInformationSession session, int timeout) {
        System.out.println("FFmpegKitConfig.asyncGetMediaInformationExecute: MediaInformationSession " + session.getSessionId());
        addSession(session);
    }
    
    public static void asyncGetMediaInformationExecute(Session session, int timeout) {
        System.out.println("FFmpegKitConfig.asyncGetMediaInformationExecute: Session " + session.getSessionId());
        addSession(session);
    }
    
    // Execution methods - these should create the right session types AND store them
    public static void ffmpegExecute(FFmpegSession ffmpegSession) {
        System.out.println("FFmpegKitConfig.ffmpegExecute: " + ffmpegSession.getSessionId());
        addSession(ffmpegSession);
    }
    
    public static void ffprobeExecute(FFprobeSession ffprobeSession) {
        System.out.println("FFmpegKitConfig.ffprobeExecute: " + ffprobeSession.getSessionId());
        addSession(ffprobeSession);
    }
    
    public static void getMediaInformationExecute(MediaInformationSession mediaInformationSession, int timeout) {
        System.out.println("FFmpegKitConfig.getMediaInformationExecute: " + mediaInformationSession.getSessionId());
        addSession(mediaInformationSession);
    }
    
    // Debug method to see all sessions
    public static void printAllSessions() {
        System.out.println("FFmpegKitConfig: Current sessions:");
        for (Map.Entry<Long, Session> entry : sessions.entrySet()) {
            System.out.println("  Session " + entry.getKey() + ": " + entry.getValue().getClass().getSimpleName());
        }
    }
    
    // All other existing methods...
    public static void enableFFmpegSessionCompleteCallback(SessionCallback callback) {}
    public static void enableFFprobeSessionCompleteCallback(SessionCallback callback) {}
    public static void enableMediaInformationSessionCompleteCallback(SessionCallback callback) {}
    public static void enableLogCallback(LogCallback callback) {}
    public static void enableStatisticsCallback(StatisticsCallback callback) {}
    public static void enableRedirection() {}
    public static void disableRedirection() {}
    public static void setFontconfigConfigurationPath(String path) {}
    public static void setFontDirectory(Object context, String fontDirectoryPath, Map<String, String> fontNameMapping) {}
    public static void setFontDirectoryList(Object context, List<String> fontDirectoryList, Map<String, String> fontNameMapping) {}
    public static String registerNewFFmpegPipe(Object context) { return ""; }
    public static void closeFFmpegPipe(String ffmpegPipePath) {}
    public static String getFFmpegVersion() { return ""; }
    public static boolean isLTSBuild() { return false; }
    public static String getBuildDate() { return ""; }
    public static void setEnvironmentVariable(String variableName, String variableValue) {}
    public static void ignoreSignal(Signal signal) {}
    public static Level getLogLevel() { return Level.AV_LOG_INFO; }
    public static void setLogLevel(Level level) {}
    public static int getSessionHistorySize() { return 0; }
    public static void setSessionHistorySize(Integer sessionHistorySize) {}
    public static Session getLastSession() { 
        if (sessions.isEmpty()) return null;
        return sessions.values().iterator().next();
    }
    public static Session getLastCompletedSession() { 
        if (sessions.isEmpty()) return null;
        return sessions.values().iterator().next();
    }
    public static List<Session> getSessions() { 
        printAllSessions();
        return new ArrayList<>(sessions.values()); 
    }
    public static void clearSessions() { sessions.clear(); }
    public static List<Session> getSessionsByState(SessionState state) { return new ArrayList<>(); }
    public static LogRedirectionStrategy getLogRedirectionStrategy() { return LogRedirectionStrategy.NEVER_PRINT_LOGS; }
    public static void setLogRedirectionStrategy(LogRedirectionStrategy strategy) {}
    public static int messagesInTransmit(long sessionId) { return 0; }
    public static String getSafParameter(Object context, Object uri, String openMode) { return ""; }
    
    // Other utility methods
    public static FFmpegSession executeAsync(String command, ExecuteCallback executeCallback) {
        FFmpegSession session = new FFmpegSession(command, executeCallback);
        addSession(session);
        return session;
    }
    
    public static FFmpegSession executeAsync(String command, ExecuteCallback executeCallback, LogCallback logCallback) {
        FFmpegSession session = new FFmpegSession(command, executeCallback, logCallback);
        addSession(session);
        return session;
    }
    
    public static FFmpegSession executeAsync(String command, ExecuteCallback executeCallback, LogCallback logCallback, StatisticsCallback statisticsCallback) {
        FFmpegSession session = new FFmpegSession(command, executeCallback, logCallback, statisticsCallback);
        addSession(session);
        return session;
    }
    
    public static boolean isRedirectionEnabled() {
        return false;
    }
}