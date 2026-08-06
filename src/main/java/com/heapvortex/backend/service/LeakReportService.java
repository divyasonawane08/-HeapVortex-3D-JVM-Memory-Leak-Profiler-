package com.heapvortex.backend.service;

import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class LeakReportService {

    // Change this to your MAT installation
    private static final String MAT_EXE = "C:\\Tools\\mat\\MemoryAnalyzer.exe";

    public String generateReport(String heapDump)
            throws Exception {

        File dump = new File(heapDump);

        if (!dump.exists()) {
            throw new RuntimeException("Heap dump not found");
        }

        String reportFolder = dump.getParent()
                + File.separator
                + "reports";

        new File(reportFolder).mkdirs();

        ProcessBuilder pb = new ProcessBuilder(

                MAT_EXE,

                "-application",

                "org.eclipse.mat.api.parse",

                heapDump

        );

        pb.inheritIO();

        Process process = pb.start();

        int exit = process.waitFor();

        if (exit != 0) {

            throw new RuntimeException(
                    "MAT analysis failed");

        }

        return reportFolder;

    }

}