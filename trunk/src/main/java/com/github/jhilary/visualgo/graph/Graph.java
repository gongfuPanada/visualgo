package com.github.jhilary.visualgo.graph;

import java.util.HashMap;
import java.util.LinkedList;

public abstract class Graph{
	HashMap<Label, Node> nodes = new HashMap<Label, Node>();
	LinkedList<Edge> edges = new LinkedList<Edge>();
	
	public Graph() {}
	
	public Graph(Graph g){
		for (Node node: g.getNodes().values()) {
			this.addNode(node.getLabel());
		}
		for (Edge edge: g.getEdges()) {
			Node from = nodes.get(edge.getFirst().getLabel());
			Node to = nodes.get(edge.getSecond().getLabel());
			this.addEdge(from, to);
		}
	}
	
	public Graph(HashMap<Label, Node> nodes, LinkedList<Edge> edges){
		this.nodes = nodes;
		this.edges = edges;
	}
	
	public HashMap<Label, Node> getNodes() {
		return nodes;
	}
	public LinkedList<Edge> getEdges() {
		return edges;
	}
	
	public abstract void addNode(Integer label);
	public abstract void addNode(Label label);
	
	public abstract void addEdge(Integer from, Integer to) throws GraphException;
	public abstract void addEdge(Label from, Label to) throws GraphException;
	
	public abstract void removeEdge(Edge edge);
	
	abstract void mergeEdge(Edge edge);
	abstract void addEdge(Node node1, Node node2);
	
}
