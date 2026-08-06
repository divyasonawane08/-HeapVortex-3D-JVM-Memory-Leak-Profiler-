package com.heapvortex.backend.websocket;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.lang.management.ThreadMXBean;
import java.util.HashMap;
import java.util.Map;

@Component
public class MetricsPublisher {

    private final SimpMessagingTemplate messagingTemplate;

    public MetricsPublisher(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @Scheduled(fixedRate = 1000)
    public void publishMetrics() {

        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

        MemoryUsage heap = memoryMXBean.getHeapMemoryUsage();

        Map<String, Object> metrics = new HashMap<>();

        metrics.put("usedHeap", heap.getUsed());
        metrics.put("maxHeap", heap.getMax());
        metrics.put("committedHeap", heap.getCommitted());
        metrics.put("threadCount", threadMXBean.getThreadCount());

        messagingTemplate.convertAndSend("/topic/metrics", metrics);
    }
}