package com.github.jhilary.visualgo.graph.factory;

import java.util.HashMap;
import java.util.LinkedList;

import com.github.jhilary.visualgo.graph.Graph;
import com.github.jhilary.visualgo.graph.UndirectedGraph;
import com.github.jhilary.visualgo.graph.exception.GraphException;

public class UndirectedGraphFactory extends GraphFactory{

	@Override
	public Graph create(HashMap<Integer, LinkedList<Integer>> data) throws GraphException{
		return new UndirectedGraph(data);
	}

	@Override
	public Graph create(LinkedList<Integer[]> data) throws GraphException {
		// TODO Auto-generated method stub
		return new UndirectedGraph(data);
	}	
}
