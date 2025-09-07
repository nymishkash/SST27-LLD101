package com.example.video;

public class SharpenAdapter {
    private final LegacySharpen legacySharpen;

    public SharpenAdapter(LegacySharpen legacySharpen) {
        this.legacySharpen = legacySharpen;
    }

    public Frame[] sharpen(Frame[] frames, int strength) {
        if (frames.length == 0) return frames;
        
        String frameHandle = framesToHandle(frames);
        legacySharpen.applySharpen(frameHandle, strength);
        return frames;
    }
    
    private String framesToHandle(Frame[] frames) {
        StringBuilder sb = new StringBuilder("FRAMES:");
        for (int i = 0; i < frames.length; i++) {
            Frame f = frames[i];
            sb.append(f.w).append("x").append(f.h);
            if (i < frames.length - 1) sb.append(",");
        }
        return sb.toString();
    }
}
