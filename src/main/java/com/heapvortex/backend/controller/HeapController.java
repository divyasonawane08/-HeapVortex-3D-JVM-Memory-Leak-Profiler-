package com.heapvortex.backend.controller;

import com.heapvortex.backend.service.HeapAnalyzerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/heap")
public class HeapController {

    private final HeapAnalyzerService service;

    public HeapController(HeapAnalyzerService service) {
        this.service = service;
    }

    @GetMapping("/analyze")
    public Object analyze(@RequestParam String file) {
        return service.analyze(file);
    }
}