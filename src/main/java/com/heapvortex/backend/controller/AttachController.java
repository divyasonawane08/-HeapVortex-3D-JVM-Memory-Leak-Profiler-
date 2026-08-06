package com.heapvortex.backend.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.heapvortex.backend.attach.JmxConnectionManager;

@RestController
@RequestMapping("/api/attach")
public class AttachController {

    private final JmxConnectionManager manager;

    public AttachController(
            JmxConnectionManager manager) {

        this.manager = manager;

    }

    @PostMapping("/{pid}")
    public String attach(
            @PathVariable String pid) throws Exception {

        manager.connect(pid);

        return "Connected to JVM " + pid;

    }

    @DeleteMapping
    public String detach() {

        manager.disconnect();

        return "Disconnected";

    }

}