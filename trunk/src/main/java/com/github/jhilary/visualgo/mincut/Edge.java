package com.github.jhilary.visualgo.mincut;

public class Edge implements Comparable<Edge>{
	private Node node1;
	private Node node2;
	public Edge(Node first, Node second){
		node1 = first;
		node2 = second;
	}
	
	public Node getFirst(){
		return node1;
	}
	
	public Node getSecond(){
		return node2;
	}
	
	public void replace(Node which, Node by){
		if(node1 == which) {
			node1 = by;
		}
		if(node2 == which) {
			node2 = by;
		}
	}
	
	public boolean contains(Node node){
		return (node1 == node || node2 == node);
	}
	
	@Override
	public String toString(){
		return "[" + node1.getLabel() + "," + node2.getLabel() + "]";
	}

	@Override
	public int compareTo(Edge edge) {
		int firstCompare = this.getFirst().compareTo(edge.getFirst());
		return firstCompare != 0 ? firstCompare : this.getSecond().compareTo(edge.getSecond()); 
	}
}
