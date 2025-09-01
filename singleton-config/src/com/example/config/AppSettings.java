package com.example.config;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

/**
 * FAULTY "Singleton": public constructor, getInstance() returns a NEW instance each time,
 * not thread-safe, reload allowed anytime, mutable global state, reflection+serialization-friendly.
 */
public class AppSettings implements Serializable {
    private static final long serialVersionUID = 1L;

    private static volatile AppSettings instance;
    private static boolean constructed;

    private final Properties props = new Properties();

    private AppSettings() {
        if (constructed) {
            throw new IllegalStateException("AppSettings instance already constructed");
        }
        constructed = true;
        instance = this; // ensures reflective construction still yields the singleton
    }

    public static AppSettings getInstance() {
        AppSettings localRef = instance;
        if (localRef == null) {
            synchronized (AppSettings.class) {
                localRef = instance;
                if (localRef == null) {
                    localRef = new AppSettings();
                    instance = localRef;
                }
            }
        }
        return localRef;
    }

    private Object readResolve() throws ObjectStreamException {
        return getInstance();
    }

    public void loadFromFile(Path file) {
        try (InputStream in = Files.newInputStream(file)) {
            props.load(in);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public String get(String key) {
        return props.getProperty(key);
    }
}
