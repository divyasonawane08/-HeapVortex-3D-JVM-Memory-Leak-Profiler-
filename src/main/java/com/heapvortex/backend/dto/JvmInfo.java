package com.heapvortex.backend.dto;

public class JvmInfo {

    private long heapUsed;
    private long heapMax;
    private int threadCount;
    private long nonHeapUsed;
    private long uptime;

    public JvmInfo() {
    }

    public JvmInfo(long heapUsed, long heapMax, int threadCount, long nonHeapUsed, long uptime) {
        this.heapUsed = heapUsed;
        this.heapMax = heapMax;
        this.threadCount = threadCount;
        this.nonHeapUsed = nonHeapUsed;
        this.uptime = uptime;
    }

    public long getHeapUsed() {
        return heapUsed;
    }

    public void setHeapUsed(long heapUsed) {
        this.heapUsed = heapUsed;
    }

    public long getHeapMax() {
        return heapMax;
    }

    public void setHeapMax(long heapMax) {
        this.heapMax = heapMax;
    }

    public int getThreadCount() {
        return threadCount;
    }

    public void setThreadCount(int threadCount) {
        this.threadCount = threadCount;
    }

    public long getNonHeapUsed() {
        return nonHeapUsed;
    }

    public void setNonHeapUsed(long nonHeapUsed) {
        this.nonHeapUsed = nonHeapUsed;
    }

    public long getUptime() {
        return uptime;
    }

    public void setUptime(long uptime) {
        this.uptime = uptime;
    }
}