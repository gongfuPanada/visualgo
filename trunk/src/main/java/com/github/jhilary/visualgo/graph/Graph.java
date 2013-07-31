package com.github.jhilary.visualgo.graph;

import java.util.List;
import java.util.Map;


public interface Graph {
	public Map<Label, Node> getNodes();
	public List<Edge> getEdges();
	
	public void addNode(Integer label);
	public void addNode(Label label);
	
	public void addEdge(Integer from, Integer to) throws GraphException;
	public void addEdge(Label from, Label to) throws GraphException;
	
	public void removeEdge(Edge edge);
	
}
