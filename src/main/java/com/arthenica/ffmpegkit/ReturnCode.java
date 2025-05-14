package com.arthenica.ffmpegkit;

/**
 * Return code class.
 */
public class ReturnCode {
    private int value;
    
    public ReturnCode(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
    
    public boolean isSuccess() {
        return value == 0;
    }
    
    public boolean isError() {
        return !isSuccess();
    }
}