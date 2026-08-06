package com.heapvortex.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/leak")
@CrossOrigin(origins = "*")
public class LeakController {

    private final RestTemplate restTemplate = new RestTemplate();

    // Change this if your mock_leak application runs on another port
    private static final String MOCK_LEAK_URL = "http://localhost:8080";

    @PostMapping("/start")
    public ResponseEntity<String> startLeak() {
        try {
            String response = restTemplate.postForObject(
                    MOCK_LEAK_URL + "/api/leak/start",
                    null,
                    String.class);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("Failed to start leak: " + e.getMessage());
        }
    }

    @PostMapping("/stop")
    public ResponseEntity<String> stopLeak() {
        try {
            String response = restTemplate.postForObject(
                    MOCK_LEAK_URL + "/api/leak/stop",
                    null,
                    String.class);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("Failed to stop leak: " + e.getMessage());
        }
    }

    @GetMapping("/status")
    public ResponseEntity<String> status() {
        try {
            String response = restTemplate.getForObject(
                    MOCK_LEAK_URL + "/api/leak/status",
                    String.class);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("Failed to get status: " + e.getMessage());
        }
    }
}