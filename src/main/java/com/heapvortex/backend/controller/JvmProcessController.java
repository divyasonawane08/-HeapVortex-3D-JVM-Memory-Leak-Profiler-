package com.heapvortex.backend.controller;

import com.heapvortex.backend.model.JvmProcess;
import com.heapvortex.backend.service.LocalJvmService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jvm/list")
@CrossOrigin("*")
public class JvmProcessController {

    private final LocalJvmService service;

    public JvmProcessController(LocalJvmService service) {
        this.service = service;
    }

    @GetMapping
    public List<JvmProcess> list() {
        return service.getRunningJvms();
    }
}