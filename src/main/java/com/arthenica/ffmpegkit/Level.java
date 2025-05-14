package com.arthenica.ffmpegkit;

public enum Level {
    AV_LOG_QUIET(-8),
    AV_LOG_PANIC(0),
    AV_LOG_FATAL(8),
    AV_LOG_ERROR(16),
    AV_LOG_WARNING(24),
    AV_LOG_INFO(32),
    AV_LOG_VERBOSE(40),
    AV_LOG_DEBUG(48),
    AV_LOG_TRACE(56);

    private final int value;

    Level(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Level from(int value) {
        for (Level level : Level.values()) {
            if (level.getValue() == value) {
                return level;
            }
        }
        return AV_LOG_INFO;
    }
}