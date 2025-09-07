package com.example.video;

import java.nio.file.Path;

public class VideoPipelineFacade {
    private final Decoder decoder;
    private final FilterEngine filterEngine;
    private final SharpenAdapter sharpenAdapter;
    private final Encoder encoder;

    public VideoPipelineFacade(Decoder decoder, FilterEngine filterEngine, 
                              SharpenAdapter sharpenAdapter, Encoder encoder) {
        this.decoder = decoder;
        this.filterEngine = filterEngine;
        this.sharpenAdapter = sharpenAdapter;
        this.encoder = encoder;
    }

    public Path process(Path src, Path out, boolean gray, Double scale, Integer sharpenStrength) {
        Frame[] frames = decoder.decode(src);

        if (gray) {
            frames = filterEngine.grayscale(frames);
        }

        if (scale != null) {
            frames = filterEngine.scale(frames, scale);
        }

        if (sharpenStrength != null) {
            frames = sharpenAdapter.sharpen(frames, sharpenStrength);
        }

        return encoder.encode(frames, out);
    }
}
