package com.github.jhilary.visualgo.graph;

import java.util.HashMap;
import java.util.LinkedList;

import com.github.jhilary.visualgo.graph.exception.GraphException;

public abstract class Graph{
    HashMap<Integer, Node> nodes = new HashMap<Integer, Node>();
    LinkedList<Edge> edges = new LinkedList<Edge>();

    public Graph() {}
    
    public Graph(HashMap<Integer, LinkedList<Integer>> nodeGraph) {};

    public Graph (Graph g){
        for (Node node: g.getNodes().values()) {
            this.addNode(node.getLabel().getValue());
        }
        for (Edge edge: g.getEdges()) {
            Node from = nodes.get(edge.getFirst().getLabel().getValue());
            Node to = nodes.get(edge.getSecond().getLabel().getValue());
            this.addEdge(from, to);
        }
    }


    public Graph(HashMap<Integer, Node> nodes, LinkedList<Edge> edges){
        this.nodes = nodes;
        this.edges = edges;
    }

    public HashMap<Integer, Node> getNodes() {
        return nodes;
    }
    
    public LinkedList<Edge> getEdges() {
        return edges;
    }

    public abstract void addNode(Integer label);

    public abstract void addEdge(Integer from, Integer to) throws GraphException;
    
    public abstract void removeEdge(Edge edge);

    abstract void mergeEdge(Edge edge);
    abstract void addEdge(Node node1, Node node2);

    public abstract int minCut() throws GraphException;

}
