package com.heapvortex.backend.controller;

import org.springframework.web.bind.annotation.*;

import com.heapvortex.backend.model.JvmMetrics;
import com.heapvortex.backend.service.JmxMetricsService;

@RestController
@RequestMapping("/api/metrics")
@CrossOrigin("*")
public class MetricsController {

        private final JmxMetricsService service;

        public MetricsController(
                        JmxMetricsService service) {
                this.service = service;
        }

        @GetMapping
        public JvmMetrics getMetrics() {

                return service.getMetrics();

        }

}