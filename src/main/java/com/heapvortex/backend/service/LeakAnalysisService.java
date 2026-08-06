package com.heapvortex.backend.service;

import com.heapvortex.backend.model.LeakAnalysisResult;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class LeakAnalysisService {

    private static final String MAT_PATH = "C:\\Tools\\mat\\MemoryAnalyzer.exe";

    public LeakAnalysisResult analyze(String heapDump)
            throws IOException, InterruptedException {

        File dumpFile = new File(heapDump);

        if (!dumpFile.exists()) {
            return new LeakAnalysisResult(
                    heapDump,
                    null,
                    "Heap dump not found");
        }

        ProcessBuilder builder = new ProcessBuilder(
                MAT_PATH,
                "-consolelog",
                heapDump);

        Process process = builder.start();

        int exitCode = process.waitFor();

        return new LeakAnalysisResult(
                heapDump,
                dumpFile.getParent(),
                exitCode == 0
                        ? "Analysis completed"
                        : "Analysis failed");
    }
}