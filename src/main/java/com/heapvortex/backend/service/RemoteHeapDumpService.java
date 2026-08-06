package com.heapvortex.backend.service;

import org.springframework.stereotype.Service;

import java.io.File;
import java.lang.management.ManagementFactory;
import java.util.HashMap;
import java.util.Map;

@Service
public class RemoteHeapDumpService {

        private static final String HEAP_DUMP_FOLDER = "C:/heapdumps/";

        /**
         * Generate JVM Heap Dump (.hprof)
         */
        public String generateHeapDump() throws Exception {

                // Create folder if it doesn't exist
                File folder = new File(HEAP_DUMP_FOLDER);
                if (!folder.exists()) {
                        folder.mkdirs();
                }

                // Current JVM PID
                String pid = ManagementFactory
                                .getRuntimeMXBean()
                                .getName()
                                .split("@")[0];

                String fileName = "java_pid" + pid + ".hprof";
                String filePath = HEAP_DUMP_FOLDER + fileName;

                System.out.println("Generating Heap Dump...");
                System.out.println("PID : " + pid);
                System.out.println("Path : " + filePath);

                Process process = Runtime.getRuntime().exec(
                                "jcmd " + pid + " GC.heap_dump " + filePath);

                int exitCode = process.waitFor();

                if (exitCode != 0) {
                        throw new Exception("Failed to generate heap dump.");
                }

                File heapFile = new File(filePath);

                if (!heapFile.exists()) {
                        throw new Exception("Heap dump file was not created.");
                }

                System.out.println("Heap Dump Generated Successfully");

                // Return only file name
                return fileName;
        }

        /**
         * Analyze Heap Dump
         */
        public Map<String, Object> analyzeHeapDump(String fileName) {

                File heapFile = new File(HEAP_DUMP_FOLDER + fileName);

                if (!heapFile.exists()) {
                        throw new RuntimeException("Heap dump not found: " + fileName);
                }

                // --------------------------------------------------
                // Dummy Analysis
                // Replace this later with Eclipse MAT integration
                // --------------------------------------------------

                Map<String, Object> result = new HashMap<>();

                result.put("suspectedClass", "java.util.HashMap");
                result.put("retainedHeapMB", 48.75);
                result.put("objectCount", 125430);
                result.put("heapFile", fileName);
                result.put("status", "Analysis Completed");

                return result;
        }

}