package com.github.jhilary.visualgo.graph.formater;

import com.github.jhilary.visualgo.graph.Graph;
import com.github.jhilary.visualgo.graph.exception.GraphException;

public interface GraphFormater{
	public Graph format(String stringData) throws GraphException ; 
}
