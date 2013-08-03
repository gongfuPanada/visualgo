package com.github.jhilary.visualgo.graph.formater;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.github.jhilary.visualgo.graph.Graph;
import com.github.jhilary.visualgo.graph.exception.GraphException;
import com.github.jhilary.visualgo.graph.factory.GraphFactory;

public class NodeGraphFormater implements GraphFormater{
	private String delimiter;
	private GraphFactory graphFactory;
	
	public NodeGraphFormater(String delimiter, GraphFactory graphFactory){
		this.delimiter = delimiter;
		this.graphFactory = graphFactory;
	}
	
	public void setDelimiter(String delimiter) {
		this.delimiter = delimiter;
	}
	
	public void setGraphFactory(GraphFactory graphFactory) {
		this.graphFactory = graphFactory;
	}
	
	@Override
	public Graph format(String stringData) throws GraphException {
		HashMap<Integer, LinkedList<Integer>> result = new HashMap<Integer, LinkedList<Integer>>();
		LinkedList<Integer> l;
		List<String> data = new LinkedList<String>(Arrays.asList(stringData.split("\n")));
		for(String line: data){
			l = new LinkedList<Integer>();
			LinkedList<String> parsedLine = new LinkedList<String>(Arrays.asList(line.split(delimiter)));
			Iterator<String> iter = parsedLine.iterator();
			int key = Integer.valueOf(iter.next());
			while(iter.hasNext()){
				l.add(Integer.valueOf(iter.next()));
			}
			result.put(key, l);
		}
		return this.graphFactory.create(result);
	}

}
