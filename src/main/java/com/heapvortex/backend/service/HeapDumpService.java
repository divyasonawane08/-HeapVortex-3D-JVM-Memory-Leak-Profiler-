package com.heapvortex.backend.service;

import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class HeapDumpService {

    private long pid = 0;

    public void setPid(long pid) {
        this.pid = pid;
    }

    public String generateHeapDump() throws Exception {

        if (pid == 0) {
            throw new RuntimeException(
                    "PID not set");
        }

        // create folder if not exists
        File folder = new File(
                "C:\\heapdumps");

        if (!folder.exists()) {
            folder.mkdirs();
        }

        String dumpPath = "C:\\heapdumps\\heapdump.hprof";

        Process process = new ProcessBuilder(
                "jcmd",
                String.valueOf(pid),
                "GC.heap_dump",
                dumpPath)
                .start();

        int exitCode = process.waitFor();

        if (exitCode != 0) {

            throw new RuntimeException(
                    "Heap dump generation failed");

        }

        return dumpPath;

    }

}