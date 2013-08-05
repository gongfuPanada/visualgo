package com.github.jhilary.visualgo.graph.factory;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import com.github.jhilary.visualgo.graph.Graph;
import com.github.jhilary.visualgo.graph.exception.GraphException;

public abstract class GraphFactory {
	public abstract Graph create(HashMap<Integer, LinkedList<Integer>> data) throws GraphException;
	public abstract Graph create(LinkedList<Integer[]> data) throws GraphException;

}
