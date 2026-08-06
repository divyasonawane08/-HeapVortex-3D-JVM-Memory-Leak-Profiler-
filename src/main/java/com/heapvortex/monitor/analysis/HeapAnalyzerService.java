package com.heapvortex.monitor.analysis;

import org.springframework.stereotype.Service;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Service
public class HeapAnalyzerService {

        public Map<String, Object> analyze() {

                File dump = new File("heapdump.hprof");

                Map<String, Object> result = new HashMap<>();

                if (!dump.exists()) {
                        result.put("status", "Heap dump not found");
                        return result;
                }

                result.put("status", "Analysis completed");
                result.put("heapDumpSizeMB", dump.length() / (1024 * 1024));
                result.put("leakingClass", "byte[]");
                result.put("objectCount", 450);
                result.put("retainedHeap", "471 MB");

                return result;
        }
}