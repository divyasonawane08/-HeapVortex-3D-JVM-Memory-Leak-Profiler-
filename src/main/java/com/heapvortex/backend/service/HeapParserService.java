package com.heapvortex.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.heapvortex.backend.dto.GraphResponse;
import com.heapvortex.backend.dto.HeapEdge;
import com.heapvortex.backend.dto.HeapNode;

@Service
public class HeapParserService {

    public GraphResponse parseHeap() {

        List<HeapNode> nodes = new ArrayList<>();
        List<HeapEdge> edges = new ArrayList<>();

        nodes.add(new HeapNode("1", "HashMap", 2500));
        nodes.add(new HeapNode("2", "ArrayList", 1800));
        nodes.add(new HeapNode("3", "String", 600));

        edges.add(new HeapEdge("1", "2"));
        edges.add(new HeapEdge("2", "3"));

        return new GraphResponse(nodes, edges);
    }

}
