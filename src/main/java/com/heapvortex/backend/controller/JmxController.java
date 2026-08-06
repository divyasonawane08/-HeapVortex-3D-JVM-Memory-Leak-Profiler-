package com.heapvortex.backend.controller;

import com.heapvortex.backend.attach.JmxConnectionManager;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/jmx")
public class JmxController {

    private final JmxConnectionManager manager;

    public JmxController(JmxConnectionManager manager) {

        this.manager = manager;

    }

    @GetMapping("/connect")
    public String connect(@RequestParam String pid) {
        try {
            manager.connect(pid);
            return "JVM Connected PID : " + pid;
        } catch (Exception e) {
            e.printStackTrace();
            return e.toString();
        }
    }

    @GetMapping("/status")
    public String status() {

        return manager.isConnected()
                ? "Connected"
                : "Not Connected";

    }

    @GetMapping("/disconnect")
    public String disconnect() {

        manager.disconnect();

        return "Disconnected";

    }

}