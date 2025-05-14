package com.arthenica.ffmpegkit;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

/**
 * FFmpeg Kit configuration.
 */
public class FFmpegKitConfig {
    // Methods from the error log
    public static void ffmpegExecute(FFmpegSession ffmpegSession) {}
    public static void enableFFmpegSessionCompleteCallback(SessionCallback callback) {}
    public static void enableFFprobeSessionCompleteCallback(SessionCallback callback) {}
    public static void enableMediaInformationSessionCompleteCallback(SessionCallback callback) {}
    public static void enableLogCallback(LogCallback callback) {}
    public static void enableStatisticsCallback(StatisticsCallback callback) {}
    public static Session getSession(long sessionId) { return new Session(); }
    public static void enableRedirection() {}
    public static void disableRedirection() {}
    public static void setFontconfigConfigurationPath(String path) {}
    
    // Replace Context with Object to avoid Android dependencies
    public static void setFontDirectory(Object context, String fontDirectoryPath, Map<String, String> fontNameMapping) {}
    public static void setFontDirectoryList(Object context, List<String> fontDirectoryList, Map<String, String> fontNameMapping) {}
    public static String registerNewFFmpegPipe(Object context) { return ""; }
    
    public static void closeFFmpegPipe(String ffmpegPipePath) {}
    public static String getFFmpegVersion() { return ""; }
    public static boolean isLTSBuild() { return false; }
    public static String getBuildDate() { return ""; }
    public static void setEnvironmentVariable(String variableName, String variableValue) {}
    public static void ignoreSignal(Signal signal) {}
    public static void asyncFFmpegExecute(FFmpegSession session) {}
    public static void asyncFFprobeExecute(FFprobeSession session) {}
    public static void asyncGetMediaInformationExecute(MediaInformationSession session, int timeout) {}
    public static Level getLogLevel() { return Level.AV_LOG_INFO; }
    public static void setLogLevel(Level level) {}
    public static int getSessionHistorySize() { return 0; }
    public static void setSessionHistorySize(Integer sessionHistorySize) {}
    public static Session getLastSession() { return new Session(); }
    public static Session getLastCompletedSession() { return new Session(); }
    public static List<Session> getSessions() { return new ArrayList<>(); }
    public static void clearSessions() {}
    public static List<Session> getSessionsByState(SessionState state) { return new ArrayList<>(); }
    public static LogRedirectionStrategy getLogRedirectionStrategy() { return LogRedirectionStrategy.NEVER_PRINT_LOGS; }
    public static void setLogRedirectionStrategy(LogRedirectionStrategy strategy) {}
    public static int messagesInTransmit(long sessionId) { return 0; }
    
    // Replace Uri with Object to avoid Android dependencies
    public static String getSafParameter(Object context, Object uri, String openMode) { return ""; }
    
    // Other utility methods
    public static FFmpegSession executeAsync(String command, ExecuteCallback executeCallback) {
        return new FFmpegSession();
    }
    
    public static FFmpegSession executeAsync(String command, ExecuteCallback executeCallback, LogCallback logCallback) {
        return new FFmpegSession();
    }
    
    public static FFmpegSession executeAsync(String command, ExecuteCallback executeCallback, LogCallback logCallback, StatisticsCallback statisticsCallback) {
        return new FFmpegSession();
    }
    
    public static boolean isRedirectionEnabled() {
        return false;
    }

    public static void ffprobeExecute(FFprobeSession ffprobeSession) {}
    
    public static void getMediaInformationExecute(MediaInformationSession mediaInformationSession, int timeout) {}
}