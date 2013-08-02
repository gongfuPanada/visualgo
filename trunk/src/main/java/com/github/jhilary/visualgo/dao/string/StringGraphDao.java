package com.github.jhilary.visualgo.dao.string;

import com.github.jhilary.visualgo.dao.GraphDao;
import com.github.jhilary.visualgo.graph.Graph;
import com.github.jhilary.visualgo.graph.GraphException;
import com.github.jhilary.visualgo.graph.GraphFormater;

public class StringGraphDao implements GraphDao {
	
	private String 	string;
	private GraphFormater graphFormater;
	
	public void setString(String string) {
		this.string = string;
	}
	
	public void setGraphFormater(GraphFormater graphFormater) {
		this.graphFormater = graphFormater;
	}
	
	@Override
	public Graph readGraph() throws GraphException{
		return graphFormater.format(this.string);
	}
}
