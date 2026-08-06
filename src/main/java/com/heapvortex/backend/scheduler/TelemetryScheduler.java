package com.heapvortex.backend.scheduler;

import com.heapvortex.backend.websocket.JvmMetricsWebSocket;
import com.heapvortex.backend.service.RemoteJvmMetricsService;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class TelemetryScheduler {

    private final JvmMetricsWebSocket webSocket;

    private final RemoteJvmMetricsService service;

    private final ObjectMapper mapper = new ObjectMapper();

    public TelemetryScheduler(
            JvmMetricsWebSocket webSocket,
            RemoteJvmMetricsService service) {

        this.webSocket = webSocket;

        this.service = service;

    }

    @Scheduled(fixedRate = 2000)
    public void sendTelemetry() {

        try {

            Object metrics = service.getMetrics();

            String json = mapper.writeValueAsString(metrics);

            webSocket.broadcast(json);

        } catch (Exception e) {

            System.out.println(
                    "JVM not connected");

        }

    }

}