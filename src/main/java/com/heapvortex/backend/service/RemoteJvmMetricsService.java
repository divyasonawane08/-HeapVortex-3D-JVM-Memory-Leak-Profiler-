package com.heapvortex.backend.service;

import com.heapvortex.backend.model.JvmMetrics;
import org.springframework.stereotype.Service;

import java.lang.management.ClassLoadingMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.OperatingSystemMXBean;
import java.lang.management.ThreadMXBean;

@Service
public class RemoteJvmMetricsService {

    public JvmMetrics getMetrics() {

        JvmMetrics metrics = new JvmMetrics();

        try {

            MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();

            double usedHeap = memoryBean.getHeapMemoryUsage().getUsed() / (1024.0 * 1024.0);

            double maxHeap = memoryBean.getHeapMemoryUsage().getMax() / (1024.0 * 1024.0);

            metrics.setUsedHeap(usedHeap);
            metrics.setMaxHeap(maxHeap);

            if (maxHeap > 0) {
                metrics.setHeapUsagePercent((usedHeap / maxHeap) * 100);
            } else {
                metrics.setHeapUsagePercent(0);
            }

            ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();

            metrics.setThreadCount(threadBean.getThreadCount());

            ClassLoadingMXBean classBean = ManagementFactory.getClassLoadingMXBean();

            metrics.setLoadedClasses(classBean.getLoadedClassCount());

            OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();

            metrics.setCpuUsage(0);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to fetch JVM metrics", e);
        }

        return metrics;
    }
}