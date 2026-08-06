package com.heapvortex.backend.service;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.lang.management.OperatingSystemMXBean;
import java.lang.management.ThreadMXBean;
import java.util.List;

import org.springframework.stereotype.Service;

import com.heapvortex.backend.dto.LiveMetrics;

@Service
public class LiveMetricsService {

        public LiveMetrics getMetrics() {
                LiveMetrics metrics = new LiveMetrics();

                // CPU
                OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();

                double cpuUsage = osBean.getSystemLoadAverage();

                if (cpuUsage < 0) {
                        cpuUsage = 0;
                }

                metrics.setCpuUsage(cpuUsage);

                // Heap
                MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();

                MemoryUsage heap = memoryBean.getHeapMemoryUsage();

                metrics.setUsedHeap(
                                heap.getUsed() / (1024 * 1024));

                metrics.setMaxHeap(
                                heap.getMax() / (1024 * 1024));

                // Threads
                ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();

                metrics.setThreadCount(
                                threadBean.getThreadCount());

                // GC
                List<GarbageCollectorMXBean> gcBeans = ManagementFactory.getGarbageCollectorMXBeans();

                long gcCount = 0;
                long gcTime = 0;

                for (GarbageCollectorMXBean gc : gcBeans) {

                        if (gc.getCollectionCount() != -1) {
                                gcCount += gc.getCollectionCount();
                        }

                        if (gc.getCollectionTime() != -1) {
                                gcTime += gc.getCollectionTime();
                        }

                }

                metrics.setGcCount(gcCount);
                metrics.setGcTime(gcTime);

                return metrics;
        }
}