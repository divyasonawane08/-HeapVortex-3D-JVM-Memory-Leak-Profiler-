package com.heapvortex.backend.model;

public class JvmProcess {

    private String pid;
    private String name;

    public JvmProcess() {
    }

    public JvmProcess(String pid, String name) {
        this.pid = pid;
        this.name = name;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}