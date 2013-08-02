package com.github.jhilary.visualgo.graph;

import java.util.HashMap;
import java.util.LinkedList;

public class UndirectedGraphFactory extends GraphFactory{

	@Override
	public Graph create(HashMap<Integer, LinkedList<Integer>> data) throws GraphException{
		return new UndirectedGraph(data);
	}
	
}
