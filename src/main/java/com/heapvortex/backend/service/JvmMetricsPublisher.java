package com.heapvortex.backend.service;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.heapvortex.backend.model.JvmMetrics;

@Service
public class JvmMetricsPublisher {

    private final SimpMessagingTemplate template;
    private final RemoteJvmMetricsService remoteJvmMetricsService;

    public JvmMetricsPublisher(
            SimpMessagingTemplate template,
            RemoteJvmMetricsService remoteJvmMetricsService) {

        this.template = template;
        this.remoteJvmMetricsService = remoteJvmMetricsService;
    }

    @Scheduled(fixedRate = 2000)
    public void sendMetrics() {

        try {

            JvmMetrics metrics = remoteJvmMetricsService.getMetrics();

            template.convertAndSend(
                    "/topic/jvm",
                    metrics);

            System.out.println(
                    "✅ Remote JVM Metrics Sent");

        } catch (Exception e) {

            System.out.println(
                    "❌ " + e.getMessage());

        }

    }

}