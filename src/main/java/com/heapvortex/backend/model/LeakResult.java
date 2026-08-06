package com.heapvortex.backend.model;

public class LeakResult {

    private String className;

    private long objectCount;

    private long retainedHeap;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public long getObjectCount() {
        return objectCount;
    }

    public void setObjectCount(long objectCount) {
        this.objectCount = objectCount;
    }

    public long getRetainedHeap() {
        return retainedHeap;
    }

    public void setRetainedHeap(long retainedHeap) {
        this.retainedHeap = retainedHeap;
    }
}