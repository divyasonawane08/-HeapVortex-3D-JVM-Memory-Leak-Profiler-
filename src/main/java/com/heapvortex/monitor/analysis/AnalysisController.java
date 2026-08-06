package com.heapvortex.monitor.analysis;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/analyze")
@CrossOrigin("*")
public class AnalysisController {

    private final HeapAnalyzerService service;

    public AnalysisController(HeapAnalyzerService service) {
        this.service = service;
    }

    @GetMapping
    public Map<String, Object> analyze() {
        return service.analyze();
    }
}