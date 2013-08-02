package com.github.jhilary.visualgo.graph.dao;

import com.github.jhilary.visualgo.graph.Graph;
import com.github.jhilary.visualgo.graph.exception.GraphException;

public interface GraphDao {
	public Graph readGraph() throws GraphException ;
}
