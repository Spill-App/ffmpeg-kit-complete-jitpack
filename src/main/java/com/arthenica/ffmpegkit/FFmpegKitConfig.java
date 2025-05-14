package com.arthenica.ffmpegkit;

import android.content.Context;
import android.net.Uri;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
    public static void setFontDirectory(Context context, String fontDirectoryPath, Map<String, String> fontNameMapping) {}
    public static void setFontDirectoryList(Context context, List<String> fontDirectoryList, Map<String, String> fontNameMapping) {}
    public static String registerNewFFmpegPipe(Context context) { return ""; }
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
    public static List<Session> getSessions() { return java.util.Collections.emptyList(); }
    public static void clearSessions() {}
    public static List<Session> getSessionsByState(SessionState state) { return java.util.Collections.emptyList(); }
    public static LogRedirectionStrategy getLogRedirectionStrategy() { return LogRedirectionStrategy.NEVER_PRINT_LOGS; }
    public static void setLogRedirectionStrategy(LogRedirectionStrategy strategy) {}
    public static int messagesInTransmit(long sessionId) { return 0; }
    public static String getSafParameter(Context context, Uri uri, String openMode) { return ""; }
    
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
}