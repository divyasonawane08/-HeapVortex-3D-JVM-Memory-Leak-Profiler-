package com.heapvortex.backend.model;

public class LeakAnalysisResult {

    private String heapDump;

    private String reportPath;

    private String status;

    public LeakAnalysisResult() {
    }

    public LeakAnalysisResult(
            String heapDump,
            String reportPath,
            String status) {

        this.heapDump = heapDump;
        this.reportPath = reportPath;
        this.status = status;
    }

    public String getHeapDump() {
        return heapDump;
    }

    public void setHeapDump(String heapDump) {
        this.heapDump = heapDump;
    }

    public String getReportPath() {
        return reportPath;
    }

    public void setReportPath(String reportPath) {
        this.reportPath = reportPath;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}