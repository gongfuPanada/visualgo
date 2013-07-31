package com.github.jhilary.visualgo.mincut;

import java.util.ArrayList;

public class Node implements Comparable<Node>{
	private Label label;
	private ArrayList<Edge> edges = new ArrayList<Edge>();
	
	public Node(Label label){
		this.label = label;
	}
	public Label getLabel(){
		return label;
	}
	
	public void setLabel(Label label){
		this.label = label;
	}
	
	public void addEdge(Edge edge){
		edges.add(edge);
	}
	
	public void addEdges(ArrayList<Edge> set){
		edges.addAll(set);
	}
	
	public ArrayList<Edge> getEdges(){
		return edges;
	}
	
	public void removeEdge(Edge edge){
		edges.remove(edge);
	}
	
	@Override
	public int compareTo(Node o){
		return this.label.compareTo(o.getLabel());
	}
	
	@Override
	public String toString(){
		return edges.toString();
	}
	
}
