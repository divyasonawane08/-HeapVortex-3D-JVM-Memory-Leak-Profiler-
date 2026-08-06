package com.heapvortex.backend.controller;

import com.heapvortex.backend.model.LeakResult;
import com.heapvortex.backend.service.HeapAnalyzerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/analyze")
public class AnalyzerController {

    private final HeapAnalyzerService service;

    public AnalyzerController(HeapAnalyzerService service) {
        this.service = service;
    }

    @GetMapping
    public LeakResult analyze(@RequestParam String file) {
        return service.analyze(file);
    }
}