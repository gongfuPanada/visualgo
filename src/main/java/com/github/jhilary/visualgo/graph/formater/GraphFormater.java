package com.github.jhilary.visualgo.graph.formater;

import java.util.List;

import com.github.jhilary.visualgo.graph.Graph;
import com.github.jhilary.visualgo.graph.exception.GraphException;

public interface GraphFormater{
	public Graph format(List<String> stringData) throws GraphException ; 
}
