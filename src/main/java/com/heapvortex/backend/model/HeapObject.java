package com.heapvortex.backend.model;

public class HeapObject {

    private String className;
    private long instances;
    private long retainedHeap;

    public HeapObject() {
    }

    public HeapObject(String className, long instances, long retainedHeap) {
        this.className = className;
        this.instances = instances;
        this.retainedHeap = retainedHeap;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public long getInstances() {
        return instances;
    }

    public void setInstances(long instances) {
        this.instances = instances;
    }

    public long getRetainedHeap() {
        return retainedHeap;
    }

    public void setRetainedHeap(long retainedHeap) {
        this.retainedHeap = retainedHeap;
    }
}