package com.heapvortex.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.heapvortex.backend.model.JvmMetrics;
import com.heapvortex.backend.service.RemoteJvmMetricsService;

@RestController
@RequestMapping("/api/jvm/list")
public class JvmController {

    private final RemoteJvmMetricsService service;

    public JvmController(RemoteJvmMetricsService service) {
        this.service = service;
    }

    @GetMapping("/metrics")
    public JvmMetrics metrics() throws Exception {

        return service.getMetrics();

    }
}