package com.example.report;

import java.nio.file.Path;
import java.util.Map;

public class ReportBundleFacade {
    private final JsonWriter jsonWriter;
    private final Zipper zipper;
    private final AuditLog auditLog;

    public ReportBundleFacade(JsonWriter jsonWriter, Zipper zipper, AuditLog auditLog) {
        this.jsonWriter = jsonWriter;
        this.zipper = zipper;
        this.auditLog = auditLog;
    }

    public Path export(Map<String, Object> data, Path outDir, String baseName) {
        Path jsonFile = jsonWriter.write(data, outDir, baseName);
        Path zipFile = outDir.resolve(baseName + ".zip");
        Path resultZip = zipper.zip(jsonFile, zipFile);
        auditLog.log("exported " + resultZip);
        return resultZip;
    }
}
