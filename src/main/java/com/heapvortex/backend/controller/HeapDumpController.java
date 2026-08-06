package com.heapvortex.backend.controller;

import com.heapvortex.backend.service.RemoteHeapDumpService;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/heapdump")
@CrossOrigin(origins = "http://localhost:5173")
public class HeapDumpController {

    private final RemoteHeapDumpService heapDumpService;

    public HeapDumpController(RemoteHeapDumpService heapDumpService) {
        this.heapDumpService = heapDumpService;
    }

    // Generate Heap Dump
    @GetMapping("/generate")
    public ResponseEntity<?> generateHeapDump() {
        try {
            String fileName = heapDumpService.generateHeapDump();

            return ResponseEntity.ok(
                    java.util.Map.of(
                            "success", true,
                            "file", fileName));

        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(
                    java.util.Map.of(
                            "success", false,
                            "message", e.getMessage()));
        }
    }

    // Analyze Heap Dump
    @GetMapping("/analyze")
    public ResponseEntity<?> analyzeHeapDump(@RequestParam String file) {

        try {
            return ResponseEntity.ok(
                    heapDumpService.analyzeHeapDump(file));

        } catch (Exception e) {

            return ResponseEntity.internalServerError().body(
                    Map.of(
                            "success", false,
                            "message", e.getMessage()));
        }
    }
}
