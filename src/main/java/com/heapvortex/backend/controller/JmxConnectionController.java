package com.heapvortex.backend.controller;

import com.heapvortex.backend.service.JmxConnectionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/jmx")
@CrossOrigin("*")
public class JmxConnectionController {

    private final JmxConnectionService service;

    public JmxConnectionController(JmxConnectionService service) {
        this.service = service;
    }

    @GetMapping("/{pid}")
    public String connect(@PathVariable String pid) {

        return service.connect(pid);

    }
}