package com.github.jhilary.visualgo.graph;

import java.util.HashMap;
import java.util.LinkedList;

public abstract class GraphFactory {
	public abstract Graph create(HashMap<Integer, LinkedList<Integer>> data) throws GraphException;
}
