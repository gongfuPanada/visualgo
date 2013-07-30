package com.github.jhilary.visualgo.mincut;

import java.util.LinkedList;


public class Node implements Comparable<Node>{
	private Integer label;
	private LinkedList<Edge> edges = new LinkedList<Edge>();
	
	public Node(Integer label){
		this.label = label;
	}
	public Integer getLabel(){
		return label;
	}
	
	public void setLabel(Integer label){
		this.label = label;
	}
	
	public void addEdge(Edge edge){
		edges.add(edge);
	}
	
	public void addEdges(LinkedList<Edge> set){
		edges.addAll(set);
	}
	
	public LinkedList<Edge> getEdges(){
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
	
//	@Override
//	public boolean equals(Object o){
//
//		if(o instanceof Node){
//			return label.equals(((Node) o).getLabel());
//		}
//		return false;
//	}
	
//	@Override
//	public int hashCode(){
//		return label.hashCode();
//	}
	
}
