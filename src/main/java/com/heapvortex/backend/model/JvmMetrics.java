package com.heapvortex.backend.model;

public class JvmMetrics {

    private double usedHeap;

    private double maxHeap;

    private double heapUsagePercent;

    private int threadCount;

    private int loadedClasses;

    private double cpuUsage;

    public double getUsedHeap() {
        return usedHeap;
    }

    public void setUsedHeap(double usedHeap) {
        this.usedHeap = usedHeap;
    }

    public double getMaxHeap() {
        return maxHeap;
    }

    public void setMaxHeap(double maxHeap) {
        this.maxHeap = maxHeap;
    }

    public double getHeapUsagePercent() {
        return heapUsagePercent;
    }

    public void setHeapUsagePercent(double heapUsagePercent) {
        this.heapUsagePercent = heapUsagePercent;
    }

    public int getThreadCount() {
        return threadCount;
    }

    public void setThreadCount(int threadCount) {
        this.threadCount = threadCount;
    }

    public int getLoadedClasses() {
        return loadedClasses;
    }

    public void setLoadedClasses(int loadedClasses) {
        this.loadedClasses = loadedClasses;
    }

    public double getCpuUsage() {
        return cpuUsage;
    }

    public void setCpuUsage(double cpuUsage) {
        this.cpuUsage = cpuUsage;
    }
}