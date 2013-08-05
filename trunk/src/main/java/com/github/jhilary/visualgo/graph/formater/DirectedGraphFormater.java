package com.github.jhilary.visualgo.graph.formater;

import java.util.LinkedList;
import java.util.List;

import com.github.jhilary.visualgo.graph.Graph;
import com.github.jhilary.visualgo.graph.exception.GraphException;
import com.github.jhilary.visualgo.graph.factory.GraphFactory;

public class DirectedGraphFormater implements GraphFormater{
	private GraphFactory graphFactory;
	
	public DirectedGraphFormater(GraphFactory graphFactory){
		this.graphFactory = graphFactory;
	}
	
	public void setGraphFactory(GraphFactory graphFactory) {
		this.graphFactory = graphFactory;
	}
	
	@Override
	public Graph format(List<String> stringData) throws GraphException {
		Integer[] l = new Integer[2];
		LinkedList<Integer[]> result = new LinkedList<Integer[]>();
		for(String line: stringData){
			l = new Integer[2];
			String[] values = line.split(" ");
			l[0] = Integer.valueOf(values[0]);
			l[1] = Integer.valueOf(values[1]);
			result.add(l);
		}
		return this.graphFactory.create(result);
	}

}
