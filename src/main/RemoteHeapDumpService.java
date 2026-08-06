package com.heapvortex.backend.service;

import com.heapvortex.backend.attach.JmxConnectionManager;
import com.heapvortex.backend.attach.JmxSession;

import org.springframework.stereotype.Service;

import javax.management.MBeanServerConnection;
import java.io.File;

import com.sun.management.HotSpotDiagnosticMXBean;

import java.lang.management.ManagementFactory;

@Service
public class RemoteHeapDumpService {

    private final JmxConnectionManager connectionManager;

    public RemoteHeapDumpService(JmxConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }

    public String createHeapDump() throws Exception {

        JmxSession session = connectionManager.getCurrentSession();

        if (session == null) {

            throw new RuntimeException(
                    "No JVM is currently attached.");
        }

        MBeanServerConnection connection = session.getConnection();

        HotSpotDiagnosticMXBean hotspotBean = ManagementFactory.newPlatformMXBeanProxy(
                connection,
                "com.sun.management:type=HotSpotDiagnostic",
                HotSpotDiagnosticMXBean.class);

        String folder = "heap-dumps";

        File directory = new File(folder);

        if (!directory.exists()) {

            directory.mkdirs();

        }

        String fileName = folder +
                File.separator +
                "heapdump_" +
                System.currentTimeMillis() +
                ".hprof";

        hotspotBean.dumpHeap(
                fileName,
                true);

        return fileName;
    }
}