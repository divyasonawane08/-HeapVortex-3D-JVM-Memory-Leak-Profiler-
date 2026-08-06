package com.heapvortex.backend.service;

import com.heapvortex.backend.attach.JmxSession;
import org.springframework.stereotype.Service;

import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.openmbean.CompositeData;
import java.util.HashMap;
import java.util.Map;

@Service
public class MetricsService {

    public Map<String, Object> getMetrics(JmxSession session) throws Exception {

        MBeanServerConnection connection = session.getConnection();

        ObjectName memoryBean = new ObjectName("java.lang:type=Memory");

        ObjectName threadBean = new ObjectName("java.lang:type=Threading");

        CompositeData heap = (CompositeData) connection.getAttribute(memoryBean, "HeapMemoryUsage");

        long usedHeap = (Long) heap.get("used");
        long maxHeap = (Long) heap.get("max");

        int threadCount = (Integer) connection.getAttribute(threadBean, "ThreadCount");

        Map<String, Object> metrics = new HashMap<>();

        metrics.put("usedHeap", usedHeap);
        metrics.put("maxHeap", maxHeap);
        metrics.put("threadCount", threadCount);

        return metrics;
    }
}