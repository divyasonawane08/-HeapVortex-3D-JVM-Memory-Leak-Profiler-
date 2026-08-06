package com.heapvortex.backend.dto;

public class HeapNode {

    private String id;
    private String className;
    private long size;

    public HeapNode() {
    }

    public HeapNode(String id, String className, long size) {
        this.id = id;
        this.className = className;
        this.size = size;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}
