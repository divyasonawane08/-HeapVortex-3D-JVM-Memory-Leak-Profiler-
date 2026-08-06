package com.heapvortex.backend.service;

import org.springframework.stereotype.Service;

import com.heapvortex.backend.model.JvmMetrics;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.ThreadMXBean;

import com.sun.management.OperatingSystemMXBean;

@Service
public class JmxMetricsService {

    public JvmMetrics getMetrics() {

        JvmMetrics metrics = new JvmMetrics();

        // Heap Memory
        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();

        long usedHeap = memoryBean
                .getHeapMemoryUsage()
                .getUsed();

        long maxHeap = memoryBean
                .getHeapMemoryUsage()
                .getMax();

        metrics.setUsedHeap(usedHeap);

        metrics.setMaxHeap(maxHeap);

        // Thread Count
        ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();

        metrics.setThreadCount(
                threadBean.getThreadCount());

        // CPU Usage
        OperatingSystemMXBean osBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

        double cpu = osBean.getCpuLoad();

        if (cpu < 0) {
            cpu = 0;
        }

        metrics.setCpuUsage(
                Math.round(cpu * 10000.0) / 100.0);

        return metrics;
    }

}