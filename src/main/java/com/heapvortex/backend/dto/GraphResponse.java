package com.heapvortex.backend.dto;

import java.util.List;

public class GraphResponse {

    private List<HeapNode> nodes;
    private List<HeapEdge> edges;

    public GraphResponse() {
    }

    public GraphResponse(List<HeapNode> nodes, List<HeapEdge> edges) {
        this.nodes = nodes;
        this.edges = edges;
    }

    public List<HeapNode> getNodes() {
        return nodes;
    }

    public void setNodes(List<HeapNode> nodes) {
        this.nodes = nodes;
    }

    public List<HeapEdge> getEdges() {
        return edges;
    }

    public void setEdges(List<HeapEdge> edges) {
        this.edges = edges;
    }
}
