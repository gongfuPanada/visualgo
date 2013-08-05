package com.github.jhilary.visualgo.graph.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import com.github.jhilary.visualgo.graph.Edge;
import com.github.jhilary.visualgo.graph.Graph;
import com.github.jhilary.visualgo.graph.Node;

public class StrongConnectedComponents {
	int t = 0;
	int s = 0;
	Graph g;
	HashMap<Integer, Node> nodes2nd = new HashMap<Integer, Node>();
	
	public StrongConnectedComponents(Graph g){
		this.g = g;
	}
	
	public void run(){
		dfs();
		scc();
	}
	
	public void scc(){
		HashMap<Integer, Integer> componentsCount = new HashMap<Integer, Integer>();
		for(Node n : nodes2nd.values()){
			if(!componentsCount.containsKey(n.getLabel().leader)){
				componentsCount.put(n.getLabel().leader, 1);
			} else {
				int value = componentsCount.get(n.getLabel().leader);
				componentsCount.put(n.getLabel().leader, value + 1);
			}
		}
		List<Integer> l = new ArrayList<Integer>(componentsCount.values());
		Collections.sort(l);
		System.out.println(l.get(l.size()-1));
		System.out.println(l.get(l.size()-2));
		System.out.println(l.get(l.size()-3));
		System.out.println(l.get(l.size()-4));
		System.out.println(l.get(l.size()-5));
	}
	
	public void dfs(){
		HashMap<Integer, Node> nodes = g.getNodes();
		int n = nodes.size();
		t = 0;
		s = 0;
		System.out.println("Reverse start");

		for (int i = n; i>0; i--){
			if(!nodes.get(i).getLabel().explored){
				s = i;
				dfsReverse(i);
			}
		}
		System.out.println("Reverse done");
		t = 0;
		s = 0;
		System.out.println("Forward start");
		for (int i = n; i>0; i--){
			if(nodes2nd.get(i).getLabel().explored){
				s = i;
				dfsForward(i);
			}
		}
		System.out.println("Forward done");

	}
	
	public void dfsReverse(int i){
		g.getNodes().get(i).getLabel().explored = true;
		g.getNodes().get(i).getLabel().leader = s;
		for(Edge edge : g.getNodes().get(i).getEdges()){
			if(edge.getSecond().getLabel().getValue() == i){
				if(!edge.getFirst().getLabel().explored){
					dfsReverse(edge.getFirst().getLabel().getValue());
				}
			}
		}
		t++;
		g.getNodes().get(i).getLabel().time = t;
		nodes2nd.put(t, g.getNodes().get(i));
	}
	
	public void dfsForward(int i){
		nodes2nd.get(i).getLabel().explored = false;
		nodes2nd.get(i).getLabel().leader = s;
		for(Edge edge : nodes2nd.get(i).getEdges()){
			if(edge.getFirst().getLabel().time == i){
				if(edge.getSecond().getLabel().explored){
					dfsForward(edge.getSecond().getLabel().time);
				}
			}
		}
	}
}
