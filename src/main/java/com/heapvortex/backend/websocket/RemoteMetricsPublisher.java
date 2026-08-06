package com.heapvortex.backend.websocket;

import org.springframework.messaging.simp.SimpMessagingTemplate;

import org.springframework.scheduling.annotation.Scheduled;

import org.springframework.stereotype.Component;

import com.heapvortex.backend.model.JvmMetrics;
import com.heapvortex.backend.service.RemoteJvmMetricsService;

@Component
public class RemoteMetricsPublisher {

    private final SelectedJvmHolder holder;

    private final RemoteJvmMetricsService metricsService;

    private final SimpMessagingTemplate messagingTemplate;

    public RemoteMetricsPublisher(

            SelectedJvmHolder holder,

            RemoteJvmMetricsService metricsService,

            SimpMessagingTemplate messagingTemplate

    ) {

        this.holder = holder;
        this.metricsService = metricsService;
        this.messagingTemplate = messagingTemplate;

    }

    @Scheduled(fixedRate = 1000)
    public void publish() {

        try {

            if (holder.getPid() == null)
                return;

            JvmMetrics metrics = metricsService.getMetrics();

            messagingTemplate.convertAndSend(
                    "/topic/jvm",
                    metrics);

            System.out.println(
                    "Streaming Remote JVM...");

        } catch (Exception e) {

            System.out.println(
                    e.getMessage());

        }

    }

}