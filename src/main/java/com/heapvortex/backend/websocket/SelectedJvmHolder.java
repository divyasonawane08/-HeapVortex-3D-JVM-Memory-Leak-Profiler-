package com.heapvortex.backend.websocket;

import org.springframework.stereotype.Component;

@Component
public class SelectedJvmHolder {

    private volatile String pid;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

}