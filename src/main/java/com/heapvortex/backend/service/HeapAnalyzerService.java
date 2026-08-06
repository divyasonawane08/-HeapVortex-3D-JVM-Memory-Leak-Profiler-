package com.heapvortex.backend.service;

import com.heapvortex.backend.model.LeakResult;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class HeapAnalyzerService {

    public LeakResult analyze(String file) {

        LeakResult result = new LeakResult();

        File dump = new File(file);

        if (!dump.exists()) {
            result.setClassName("Heap dump not found");
            result.setObjectCount(0);
            result.setRetainedHeap(0);
            return result;
        }

        result.setClassName("byte[]");
        result.setObjectCount(450);
        result.setRetainedHeap(471L * 1024 * 1024);

        return result;
    }
}