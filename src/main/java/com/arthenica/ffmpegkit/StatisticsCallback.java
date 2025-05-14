package com.arthenica.ffmpegkit;

@FunctionalInterface
public interface StatisticsCallback {

    /**
     * <p>Called when a statistics entry is received.
     *
     * @param statistics statistics entry
     */
    void apply(final Statistics statistics);

}
