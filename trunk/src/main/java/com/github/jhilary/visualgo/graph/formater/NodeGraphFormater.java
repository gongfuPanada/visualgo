package com.github.jhilary.visualgo.graph.formater;

import java.util.Arrays;
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
	public Graph format(List<String> stringData) throws GraphException {
		
		LinkedList<Integer[]> result = new LinkedList<Integer[]>();
		for(String line: stringData){
			LinkedList<String> parsedLine = new LinkedList<String>(Arrays.asList(line.split(delimiter)));
			Iterator<String> iter = parsedLine.iterator();
			int key = Integer.valueOf(iter.next());
			while(iter.hasNext()){
				Integer[] i = new Integer[2];
				i[0] = key;
				i[1] = Integer.valueOf(iter.next());
				if(i[0] <= i[1]){
					result.add(i);
				} 
			}
		}
		return this.graphFactory.create(result);
	}

}
