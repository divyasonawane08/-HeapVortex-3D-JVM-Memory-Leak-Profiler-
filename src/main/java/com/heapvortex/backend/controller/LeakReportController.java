package com.heapvortex.backend.controller;

import com.heapvortex.backend.service.LeakReportService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/report")
@CrossOrigin("*")
public class LeakReportController {

    private final LeakReportService service;

    public LeakReportController(
            LeakReportService service) {

        this.service = service;

    }

    @PostMapping
    public String report(

            @RequestParam String heapDump

    ) throws Exception {

        return service.generateReport(heapDump);

    }

}