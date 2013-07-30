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
	
//	@Override
//	public boolean equals(Object o){
//
//		if(o instanceof Edge){
//			Edge e = (Edge)o;
//			if(this.getFirst().equals(e.getFirst()) && this.getSecond().equals(e.getSecond())){
//				return true;
//			}
//			if(this.getFirst().equals(e.getSecond()) && this.getSecond().equals(e.getFirst())){
//				return true;
//			}
//		}
//		return false;
//	}
	
//	@Override
//	public boolean equals(Object o){
//
//		if(o instanceof Edge){
//			Edge e = (Edge)o;
//			if(this.getFirst().equals(e.getFirst()) && this.getSecond().equals(e.getSecond())){
//				return true;
//			}
//			if(this.getFirst().equals(e.getSecond()) && this.getSecond().equals(e.getFirst())){
//				return true;
//			}
//		}
//		return false;
//	}
//	
//	@Override
//	public int hashCode(){
//		return node1.hashCode()+node2.hashCode();
//	}
}
