package com.heapvortex.backend.controller;

import com.heapvortex.backend.model.LeakResult;
import com.heapvortex.backend.service.HeapAnalyzerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/heap-analyze")
public class HeapAnalyzerController {

    private final HeapAnalyzerService service;

    public HeapAnalyzerController(HeapAnalyzerService service) {
        this.service = service;
    }

    @GetMapping
    public LeakResult analyze(@RequestParam String file) {
        return service.analyze(file);
    }
}