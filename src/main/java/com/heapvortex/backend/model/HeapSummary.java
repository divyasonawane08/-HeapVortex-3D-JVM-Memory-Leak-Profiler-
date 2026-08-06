package com.heapvortex.backend.model;

import java.util.List;

public class HeapSummary {

    private long totalHeap;
    private long usedHeap;
    private List<HeapObject> topObjects;

    public HeapSummary() {
    }

    public HeapSummary(long totalHeap, long usedHeap, List<HeapObject> topObjects) {
        this.totalHeap = totalHeap;
        this.usedHeap = usedHeap;
        this.topObjects = topObjects;
    }

    public long getTotalHeap() {
        return totalHeap;
    }

    public void setTotalHeap(long totalHeap) {
        this.totalHeap = totalHeap;
    }

    public long getUsedHeap() {
        return usedHeap;
    }

    public void setUsedHeap(long usedHeap) {
        this.usedHeap = usedHeap;
    }

    public List<HeapObject> getTopObjects() {
        return topObjects;
    }

    public void setTopObjects(List<HeapObject> topObjects) {
        this.topObjects = topObjects;
    }
}