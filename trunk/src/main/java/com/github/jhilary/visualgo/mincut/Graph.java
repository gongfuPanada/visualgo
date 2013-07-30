package com.github.jhilary.visualgo.mincut;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;


public class Graph {
	HashMap<Integer, Node> nodes = new HashMap<Integer, Node>();
	LinkedList<Edge> edges = new LinkedList<Edge>();
	
	public Graph(HashMap<Integer, LinkedList<Integer>> nodeGraph){
		Iterator<Integer> iter = nodeGraph.keySet().iterator();
		while(iter.hasNext()){
			Integer key = iter.next();
			addNode(key);
			Iterator<Integer> neighbours = nodeGraph.get(key).iterator();
			while(neighbours.hasNext()){
				Integer neighbour = neighbours.next();
				if(key <= neighbour){
					addEdge(key, neighbour);
				} 
			}
		}
	}
	
	public void addNode(Integer label){
		if (!nodes.containsKey(label)){
			nodes.put(label, new Node(label));
		}
	}
	
	public void addEdge(Integer from, Integer to){
		addNode(from);
		addNode(to);
		Node nodeFrom = nodes.get(from);
		Node nodeTo = nodes.get(to);
		Edge edge = new Edge(nodeFrom, nodeTo);
		edges.add(edge);
		nodeFrom.addEdge(edge);
		nodeTo.addEdge(edge);
	}
	
	public void removeEdge(Integer from, Integer to){
		Node nodeFrom = nodes.get(from);
		Node nodeTo = nodes.get(to);
		Edge e = new Edge(nodeFrom, nodeTo);
		edges.remove(e);
		nodeFrom.removeEdge(e);
		nodeTo.removeEdge(e);
	}
	
	public void removeEdge(Edge edge) {
		edges.remove(edge);
		edge.getFirst().removeEdge(edge);
		edge.getSecond().removeEdge(edge);
	}
	
	public LinkedList<Edge> getEdges(){
		return edges;
	}
	
	public HashMap<Integer, Node> getNodes(){
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
			Iterator<Edge> nodeFromEdges = nodeFrom.getEdges().iterator();
			while(nodeFromEdges.hasNext()){
				nodeFromEdges.next().replace(nodeFrom, nodeTo);
			}
			Iterator<Edge> nodeToEdges = nodeTo.getEdges().iterator();
			while(nodeToEdges.hasNext()){
				nodeToEdges.next().replace(nodeFrom, nodeTo);
			}
			nodeTo.addEdges(nodeFrom.getEdges());
			nodes.remove(nodeFrom.getLabel());
		}
	}
}
