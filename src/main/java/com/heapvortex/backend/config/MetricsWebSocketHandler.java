package com.heapvortex.backend.config;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.lang.management.ThreadMXBean;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class MetricsWebSocketHandler extends TextWebSocketHandler {

    private final Set<WebSocketSession> sessions = ConcurrentHashMap.newKeySet();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {

        sessions.add(session);

        System.out.println("WebSocket Connected : " + session.getId());

        sendMetrics(session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message)
            throws Exception {

        // Client can send "metrics" to receive latest JVM metrics
        if ("metrics".equalsIgnoreCase(message.getPayload())) {
            sendMetrics(session);
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session,
            CloseStatus status) throws Exception {

        sessions.remove(session);

        System.out.println("WebSocket Disconnected : " + session.getId());
    }

    private void sendMetrics(WebSocketSession session) throws IOException {

        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

        MemoryUsage heap = memoryMXBean.getHeapMemoryUsage();

        long usedHeap = heap.getUsed();
        long committedHeap = heap.getCommitted();
        long maxHeap = heap.getMax();
        int threadCount = threadMXBean.getThreadCount();

        String json = String.format(
                """
                        {
                          "usedHeap": %d,
                          "committedHeap": %d,
                          "maxHeap": %d,
                          "threadCount": %d
                        }
                        """,
                usedHeap,
                committedHeap,
                maxHeap,
                threadCount);

        session.sendMessage(new TextMessage(json));
    }

    public void broadcastMetrics() {

        sessions.removeIf(session -> !session.isOpen());

        for (WebSocketSession session : sessions) {
            try {
                sendMetrics(session);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}