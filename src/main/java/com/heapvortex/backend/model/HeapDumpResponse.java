package com.heapvortex.backend.model;

public class HeapDumpResponse {

    private boolean success;

    private String file;

    private String message;

    public HeapDumpResponse(
            boolean success,
            String file,
            String message) {

        this.success = success;

        this.file = file;

        this.message = message;

    }

    public boolean isSuccess() {

        return success;

    }

    public String getFile() {

        return file;

    }

    public String getMessage() {

        return message;

    }

    public void setSuccess(boolean success) {

        this.success = success;

    }

    public void setFile(String file) {

        this.file = file;

    }

    public void setMessage(String message) {

        this.message = message;

    }

}