package com.github.jhilary.visualgo.dao;

import com.github.jhilary.visualgo.graph.Graph;
import com.github.jhilary.visualgo.graph.GraphException;

public interface GraphDao {
	public Graph readGraph() throws GraphException ;
}
