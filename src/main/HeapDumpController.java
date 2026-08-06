package com.heapvortex.backend.controller;

import com.heapvortex.backend.service.RemoteHeapDumpService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/heapdump")
public class HeapDumpController {

    private final RemoteHeapDumpService service;

    public HeapDumpController(RemoteHeapDumpService service) {

        this.service = service;

    }

    @PostMapping
    public String generateDump() throws Exception {

        return service.createHeapDump();

    }
}