package com.heapvortex.backend.scheduler;

import com.heapvortex.backend.config.MetricsWebSocketHandler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class MetricsScheduler {

    private final MetricsWebSocketHandler handler;

    public MetricsScheduler(MetricsWebSocketHandler handler) {
        this.handler = handler;
    }

    @Scheduled(fixedRate = 1000)
    public void publishMetrics() {
        handler.broadcastMetrics();
    }
}