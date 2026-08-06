package com.heapvortex.backend.service;

import com.heapvortex.backend.dto.MemoryData;
import org.springframework.stereotype.Service;

import java.lang.management.*;

@Service
public class JmxTelemetryService {

    public MemoryData getMemoryData() {

        MemoryData data = new MemoryData();

        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();

        MemoryUsage heap = memoryBean.getHeapMemoryUsage();

        MemoryUsage nonHeap = memoryBean.getNonHeapMemoryUsage();

        data.setHeapUsed(heap.getUsed());

        data.setHeapCommitted(heap.getCommitted());

        data.setHeapMax(heap.getMax());

        data.setNonHeapUsed(nonHeap.getUsed());

        ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();

        data.setThreadCount(threadBean.getThreadCount());

        long gcCount = 0;

        long gcTime = 0;

        for (GarbageCollectorMXBean gc : ManagementFactory.getGarbageCollectorMXBeans()) {

            if (gc.getCollectionCount() > 0) {

                gcCount += gc.getCollectionCount();

            }

            if (gc.getCollectionTime() > 0) {

                gcTime += gc.getCollectionTime();

            }

        }

        data.setGcCount(gcCount);

        data.setGcTime(gcTime);

        return data;

    }

}