package com.github.jhilary.visualgo.graph;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;


public class UndirectedGraph extends Graph{
	
	public UndirectedGraph() {		
		super();
	}
	
	public UndirectedGraph(UndirectedGraph g) {		
		super(g);
	}
	
	public UndirectedGraph(HashMap<Integer, LinkedList<Integer>> nodeGraph) throws GraphException{
		super(new HashMap<Label, Node>(), new LinkedList<Edge>());
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
	
	@Override
	public void addNode(Integer label){
		addNode(new Label(label));
	}
	
	@Override
	public void addNode(Label label){
		if (!nodes.containsKey(label)){
			nodes.put(label, new Node(label));
		}
	}
	
	@Override
	public void addEdge(Integer from, Integer to) throws GraphException{
		addEdge(new Label(from), new Label(to));
	}
	
	@Override
	public void addEdge(Label from, Label to) throws GraphException{
		Node nodeFrom = nodes.get(from);
		Node nodeTo = nodes.get(to);
		if(nodeFrom == null || nodeTo == null){
			throw new GraphException("There are no exist nodes with these labels");
		} 
		this.addEdge(nodeFrom, nodeTo);
	}
	
	@Override
	void addEdge(Node from, Node to) {
		Edge edge = new Edge(from, to);
		edges.add(edge);
		from.addEdge(edge);
		to.addEdge(edge);
	}
	
	@Override
	public void removeEdge(Edge edge) {
		edges.remove(edge);
		edge.getFirst().removeEdge(edge);
		edge.getSecond().removeEdge(edge);
	}

	@Override
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
	
	private static int minCutIteration(UndirectedGraph g){
		Collections.shuffle(g.getEdges());
		while(g.getNodes().size() != 2 && g.getEdges().size() != 0){
			Edge edge = g.getEdges().getFirst();
			g.mergeEdge(edge);
		}
		int mincut = 0;
		Node first = g.getNodes().get(g.getNodes().keySet().iterator().next());
		Iterator<Edge> mincutEdges = first.getEdges().iterator();
		while(mincutEdges.hasNext()){
			Edge e = mincutEdges.next();
			if(e.getFirst() != e.getSecond()){
				mincut++;
			}
		}
		return mincut;
	}
	
	@Override
	public int minCut() throws GraphException{
		UndirectedGraph workGraph;
		int min = Integer.MAX_VALUE;
		for(int i = 0 ; i < 1000; i++){
			workGraph = new UndirectedGraph(this);
			int res = minCutIteration(workGraph);
			if(res < min){
				min = res;
			}
		}
	return min;
	}
}
