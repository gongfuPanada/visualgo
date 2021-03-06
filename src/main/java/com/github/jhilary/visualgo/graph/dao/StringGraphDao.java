package com.github.jhilary.visualgo.graph.dao;

import java.util.Arrays;
import java.util.List;

import com.github.jhilary.visualgo.graph.Graph;
import com.github.jhilary.visualgo.graph.exception.GraphException;
import com.github.jhilary.visualgo.graph.formater.GraphFormater;

public class StringGraphDao implements GraphDao {
	
	private String 	string;
	private GraphFormater graphFormater;
	
	public StringGraphDao(String string, GraphFormater graphFormater){
		this.string = string;
		this.graphFormater = graphFormater;
	}
	public void setString(String string) {
		this.string = string;
	}
	
	public void setGraphFormater(GraphFormater graphFormater) {
		this.graphFormater = graphFormater;
	}
	
	@Override
	public Graph readGraph() throws GraphException{
		List<String> text = Arrays.asList(string.split("\n"));
		return graphFormater.format(text);
	}
}
