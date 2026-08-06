package com.heapvortex.backend.dto;

public class MetricsResponse {

    private double cpuUsage;
    private long usedHeap;
    private long maxHeap;
    private int threadCount;

    public MetricsResponse() {
    }

    public MetricsResponse(double cpuUsage, long usedHeap, long maxHeap, int threadCount) {
        this.cpuUsage = cpuUsage;
        this.usedHeap = usedHeap;
        this.maxHeap = maxHeap;
        this.threadCount = threadCount;
    }

    public double getCpuUsage() {
        return cpuUsage;
    }

    public void setCpuUsage(double cpuUsage) {
        this.cpuUsage = cpuUsage;
    }

    public long getUsedHeap() {
        return usedHeap;
    }

    public void setUsedHeap(long usedHeap) {
        this.usedHeap = usedHeap;
    }

    public long getMaxHeap() {
        return maxHeap;
    }

    public void setMaxHeap(long maxHeap) {
        this.maxHeap = maxHeap;
    }

    public int getThreadCount() {
        return threadCount;
    }

    public void setThreadCount(int threadCount) {
        this.threadCount = threadCount;
    }
}
