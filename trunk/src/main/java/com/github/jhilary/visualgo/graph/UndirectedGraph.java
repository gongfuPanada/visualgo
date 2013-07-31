package com.github.jhilary.visualgo.graph;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;


public class UndirectedGraph implements Graph, Cloneable{
	HashMap<Label, Node> nodes = new HashMap<Label, Node>();
	LinkedList<Edge> edges = new LinkedList<Edge>();
	
	public UndirectedGraph() {}
	
	public UndirectedGraph(HashMap<Integer, LinkedList<Integer>> nodeGraph) throws GraphException{
		Iterator<Integer> iter = nodeGraph.keySet().iterator();
		while(iter.hasNext()){
			Integer key = iter.next();
			addNode(key);
			Iterator<Integer> neighbours = nodeGraph.get(key).iterator();
			while(neighbours.hasNext()){
				Integer neighbour = neighbours.next();
				addNode(neighbour);
				if(key <= neighbour){
					addEdge(key, neighbour);
				} 
			}
		}
	}
	
	public void addNode(Integer label){
		addNode(new Label(label));
	}
	
	public void addNode(Label label){
		if (!nodes.containsKey(label)){
			nodes.put(label, new Node(label));
		}
	}
	
	public void addEdge(Integer from, Integer to) throws GraphException{
		addEdge(new Label(from), new Label(to));
	}
	
	public void addEdge(Label from, Label to) throws GraphException{
		Node nodeFrom = nodes.get(from);
		Node nodeTo = nodes.get(to);
		if(nodeFrom == null || nodeTo == null){
			throw new GraphException("There are no exist nodes with these labels");
		} 
		this.addEdge(nodeFrom, nodeTo);
	}
	
	private void addEdge(Node from, Node to) {
		Edge edge = new Edge(from, to);
		edges.add(edge);
		from.addEdge(edge);
		to.addEdge(edge);
	}
	
	public void removeEdge(Edge edge) {
		edges.remove(edge);
		edge.getFirst().removeEdge(edge);
		edge.getSecond().removeEdge(edge);
	}
	
	public LinkedList<Edge> getEdges(){
		return edges;
	}
	
	public HashMap<Label, Node> getNodes(){
		return nodes;
	}
	
	public int getNodesSize(){
		return nodes.size();
	}

	public void mergeEdge(Edge edge){
		Node nodeFrom = edge.getFirst();
		Node nodeTo = edge.getSecond();
		removeEdge(edge);
		if(nodeFrom != nodeTo) {
			nodeTo.addEdges(nodeFrom.getEdges());
			for(Edge e : nodeTo.getEdges()){
				e.replace(nodeFrom, nodeTo);
			}
			nodes.remove(nodeFrom.getLabel());
		}
	}
	
	@Override
	public UndirectedGraph clone() {
		UndirectedGraph newGraph = new UndirectedGraph();
		for (Node node: this.getNodes().values()) {
			newGraph.addNode(node.getLabel());
		}
		for (Edge edge: this.getEdges()) {
			Node from = newGraph.getNodes().get(edge.getFirst().getLabel());
			Node to = newGraph.getNodes().get(edge.getSecond().getLabel());
			newGraph.addEdge(from, to);
		}
		return newGraph;
	}
}