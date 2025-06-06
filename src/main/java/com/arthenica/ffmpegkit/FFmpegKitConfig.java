package com.arthenica.ffmpegkit;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * FFmpeg Kit configuration.
 */
public class FFmpegKitConfig {
    private static final AtomicLong sessionIdCounter = new AtomicLong(1);
    private static final Map<Long, Session> sessions = new ConcurrentHashMap<>();
    private static final ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
    
    // Callback storage
    private static SessionCallback ffmpegSessionCompleteCallback;
    private static SessionCallback ffprobeSessionCompleteCallback;
    private static SessionCallback mediaInformationSessionCompleteCallback;
    
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
    
    // MISSING METHODS - Add these back:
    
    // Synchronous execution methods
    public static void ffmpegExecute(FFmpegSession ffmpegSession) {
        System.out.println("FFmpegKitConfig.ffmpegExecute: " + ffmpegSession.getSessionId());
        addSession(ffmpegSession);
        simulateExecution(ffmpegSession);
    }
    
    public static void ffprobeExecute(FFprobeSession ffprobeSession) {
        System.out.println("FFmpegKitConfig.ffprobeExecute: " + ffprobeSession.getSessionId());
        addSession(ffprobeSession);
        simulateExecution(ffprobeSession);
    }
    
    public static void getMediaInformationExecute(MediaInformationSession mediaInformationSession, int timeout) {
        System.out.println("FFmpegKitConfig.getMediaInformationExecute: " + mediaInformationSession.getSessionId());
        addSession(mediaInformationSession);
        simulateExecution(mediaInformationSession);
    }
    
    // Asynchronous execution methods
    public static void asyncFFmpegExecute(FFmpegSession session) {
        System.out.println("FFmpegKitConfig.asyncFFmpegExecute: FFmpegSession " + session.getSessionId());
        addSession(session);
        simulateExecution(session);
    }
    
    public static void asyncFFmpegExecute(Session session) {
        System.out.println("FFmpegKitConfig.asyncFFmpegExecute: Session " + session.getSessionId());
        addSession(session);
        simulateExecution(session);
    }
    
    public static void asyncFFprobeExecute(FFprobeSession session) {
        System.out.println("FFmpegKitConfig.asyncFFprobeExecute: FFprobeSession " + session.getSessionId());
        addSession(session);
        simulateExecution(session);
    }
    
    public static void asyncFFprobeExecute(Session session) {
        System.out.println("FFmpegKitConfig.asyncFFprobeExecute: Session " + session.getSessionId());
        addSession(session);
        simulateExecution(session);
    }
    
    public static void asyncGetMediaInformationExecute(MediaInformationSession session, int timeout) {
        System.out.println("FFmpegKitConfig.asyncGetMediaInformationExecute: MediaInformationSession " + session.getSessionId());
        addSession(session);
        simulateExecution(session);
    }
    
    public static void asyncGetMediaInformationExecute(Session session, int timeout) {
        System.out.println("FFmpegKitConfig.asyncGetMediaInformationExecute: Session " + session.getSessionId());
        addSession(session);
        simulateExecution(session);
    }
    
    private static void simulateExecution(Session session) {
        // Update session state to running
        session.setState(SessionState.RUNNING);
        session.setStartTime(new Date());
        
        // Simulate execution completion after a short delay
        executor.schedule(() -> {
            System.out.println("FFmpegKitConfig: Simulating completion of session " + session.getSessionId());
            
            // Parse the command to find output file path
            String command = session.getCommand();
            if (command != null) {
                System.out.println("FFmpegKitConfig: Executing command: " + command);
                String outputPath = extractOutputPath(command);
                if (outputPath != null) {
                    createDummyOutputFile(command, outputPath);
                }
            }
            
            // Update session state
            session.setState(SessionState.COMPLETED);
            session.setEndTime(new Date());
            session.setReturnCode(new ReturnCode(0)); // Success
            
            // Trigger appropriate completion callback
            if (session instanceof FFmpegSession && ffmpegSessionCompleteCallback != null) {
                System.out.println("FFmpegKitConfig: Calling FFmpeg completion callback for session " + session.getSessionId());
                ffmpegSessionCompleteCallback.apply(session);
            } else if (session instanceof FFprobeSession && ffprobeSessionCompleteCallback != null) {
                System.out.println("FFmpegKitConfig: Calling FFprobe completion callback for session " + session.getSessionId());
                ffprobeSessionCompleteCallback.apply(session);
            } else if (session instanceof MediaInformationSession && mediaInformationSessionCompleteCallback != null) {
                System.out.println("FFmpegKitConfig: Calling MediaInformation completion callback for session " + session.getSessionId());
                mediaInformationSessionCompleteCallback.apply(session);
            } else if (session.isFFmpeg() && ffmpegSessionCompleteCallback != null) {
                System.out.println("FFmpegKitConfig: Calling FFmpeg completion callback for generic session " + session.getSessionId());
                ffmpegSessionCompleteCallback.apply(session);
            } else {
                System.out.println("FFmpegKitConfig: No completion callback registered for session " + session.getSessionId());
            }
        }, 1, TimeUnit.SECONDS); // Complete after 1 second
    }

    // Helper method to extract output path from FFmpeg command
    private static String extractOutputPath(String command) {
        try {
            String[] parts = command.split("\\s+");
            // Look for the last argument that looks like a file path
            for (int i = parts.length - 1; i >= 0; i--) {
                String part = parts[i];
                if (part.contains("/") && (part.endsWith(".mp4") || part.endsWith(".mov") || part.endsWith(".avi"))) {
                    System.out.println("FFmpegKitConfig: Found output path: " + part);
                    return part;
                }
            }
        } catch (Exception e) {
            System.out.println("FFmpegKitConfig: Error parsing command: " + e.getMessage());
        }
        return null;
    }

    // Enhanced createDummyOutputFile method that copies input to output
    private static void createDummyOutputFile(String command, String outputPath) {
        try {
            // Extract input path from command
            String inputPath = extractInputPath(command);
            
            java.io.File outputFile = new java.io.File(outputPath);
            java.io.File parentDir = outputFile.getParentFile();
            
            // Create parent directories if they don't exist
            if (parentDir != null && !parentDir.exists()) {
                boolean created = parentDir.mkdirs();
                System.out.println("FFmpegKitConfig: Created parent directories: " + created);
            }
            
            if (inputPath != null) {
                java.io.File inputFile = new java.io.File(inputPath);
                if (inputFile.exists()) {
                    // Copy input file to output location
                    copyFile(inputFile, outputFile);
                    System.out.println("FFmpegKitConfig: Copied input file to output: " + outputPath);
                } else {
                    System.out.println("FFmpegKitConfig: Input file not found: " + inputPath);
                    createEmptyVideoFile(outputFile);
                }
            } else {
                createEmptyVideoFile(outputFile);
            }
        } catch (Exception e) {
            System.out.println("FFmpegKitConfig: Error creating output file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static String extractInputPath(String command) {
        try {
            String[] parts = command.split("\\s+");
            // Look for -i flag followed by input path
            for (int i = 0; i < parts.length - 1; i++) {
                if ("-i".equals(parts[i])) {
                    return parts[i + 1];
                }
            }
        } catch (Exception e) {
            System.out.println("FFmpegKitConfig: Error parsing input path: " + e.getMessage());
        }
        return null;
    }

    private static void copyFile(java.io.File source, java.io.File dest) throws java.io.IOException {
        try (java.io.FileInputStream fis = new java.io.FileInputStream(source);
            java.io.FileOutputStream fos = new java.io.FileOutputStream(dest)) {
            
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }
        }
    }

    private static void createEmptyVideoFile(java.io.File file) throws java.io.IOException {
        if (file.createNewFile()) {
            System.out.println("FFmpegKitConfig: Created empty output file: " + file.getAbsolutePath());
            // Write minimal content so the file isn't completely empty
            try (java.io.FileOutputStream fos = new java.io.FileOutputStream(file)) {
                fos.write("dummy video content".getBytes());
            }
        }
    }
    
    // Callback registration methods
    public static void enableFFmpegSessionCompleteCallback(SessionCallback callback) {
        System.out.println("FFmpegKitConfig: Registering FFmpeg session complete callback");
        ffmpegSessionCompleteCallback = callback;
    }
    
    public static void enableFFprobeSessionCompleteCallback(SessionCallback callback) {
        System.out.println("FFmpegKitConfig: Registering FFprobe session complete callback");
        ffprobeSessionCompleteCallback = callback;
    }
    
    public static void enableMediaInformationSessionCompleteCallback(SessionCallback callback) {
        System.out.println("FFmpegKitConfig: Registering MediaInformation session complete callback");
        mediaInformationSessionCompleteCallback = callback;
    }
    
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
    
    // Debug method to see all sessions
    public static void printAllSessions() {
        System.out.println("FFmpegKitConfig: Current sessions:");
        for (Map.Entry<Long, Session> entry : sessions.entrySet()) {
            System.out.println("  Session " + entry.getKey() + ": " + entry.getValue().getClass().getSimpleName() + " [" + entry.getValue().getState() + "]");
        }
    }
    
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