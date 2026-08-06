package com.heapvortex.backend.controller;

import com.heapvortex.backend.dto.MemoryData;
import com.heapvortex.backend.service.JmxTelemetryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class MemoryController {

    private final JmxTelemetryService telemetryService;

    public MemoryController(
            JmxTelemetryService telemetryService) {

        this.telemetryService = telemetryService;

    }

    @GetMapping("/memory")
    public MemoryData memory() {

        return telemetryService.getMemoryData();

    }

}