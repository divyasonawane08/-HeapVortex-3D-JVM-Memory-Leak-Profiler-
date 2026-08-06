package com.heapvortex.backend.model;

public class AttachResult {

    private boolean success;

    private String message;

    private String pid;

    public AttachResult() {
    }

    public AttachResult(
            boolean success,
            String message,
            String pid) {

        this.success = success;
        this.message = message;
        this.pid = pid;

    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

}