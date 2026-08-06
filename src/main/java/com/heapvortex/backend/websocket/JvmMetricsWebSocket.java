package com.heapvortex.backend.websocket;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class JvmMetricsWebSocket {

    private final SimpMessagingTemplate template;

    public JvmMetricsWebSocket(
            SimpMessagingTemplate template) {

        this.template = template;

    }

    public void broadcast(String message) {

        template.convertAndSend(
                "/topic/jvm",
                message);

    }

}