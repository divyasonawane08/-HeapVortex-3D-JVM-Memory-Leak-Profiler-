package com.heapvortex.backend.controller;

import org.springframework.web.bind.annotation.*;

import com.heapvortex.backend.model.JvmMetrics;
import com.heapvortex.backend.service.RemoteJvmMetricsService;

@RestController
@RequestMapping("/api/remote")
@CrossOrigin("*")
public class RemoteMetricsController {

    private final RemoteJvmMetricsService service;

    public RemoteMetricsController(RemoteJvmMetricsService service) {
        this.service = service;
    }

    @GetMapping
    public JvmMetrics getMetrics() throws Exception {
        return service.getMetrics();
    }
}