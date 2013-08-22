package com.github.jhilary.visualgo.graph;

import java.util.HashMap;
import java.util.LinkedList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.github.jhilary.visualgo.graph.exception.GraphException;
import com.github.jhilary.visualgo.web.GraphSerializer;

@JsonSerialize(using=GraphSerializer.class)
public abstract class Graph{
    HashMap<Integer, Node> nodes = new HashMap<Integer, Node>();
    LinkedList<Edge> edges = new LinkedList<Edge>();
    int id = 0;

    public int getId(){
        return id;
    }
    
    public Graph() {
    }
    
    public Graph(HashMap<Integer, LinkedList<Integer>> nodeGraph) {
    };

    public Graph (Graph g){
        for (Node node: g.getNodes().values()) {
            this.addNode(node.getLabel().getValue());
        }
        for (Edge edge: g.getEdges()) {
            Node from = this.nodes.get(edge.getFirst().getLabel().getValue());
            Node to = this.nodes.get(edge.getSecond().getLabel().getValue());
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
