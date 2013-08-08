package com.github.jhilary.visualgo.graph.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.github.jhilary.visualgo.graph.Graph;
import com.github.jhilary.visualgo.graph.exception.GraphException;
import com.github.jhilary.visualgo.graph.formater.GraphFormater;
import com.google.common.base.Charsets;
import com.google.common.io.Files;

public class FileGraphDao implements GraphDao{
	
	private String fileName;
	private GraphFormater graphFormater;

	public FileGraphDao(String fileName, GraphFormater graphFormater){
		this.fileName = fileName;
		this.graphFormater = graphFormater;
	}
	
	public void setGraphFormater(GraphFormater graphFormater) {
		this.graphFormater = graphFormater;
	}

	@Override
	public Graph readGraph() throws GraphException {
		try{
			List<String> lines = Files.readLines(new File(fileName), Charsets.UTF_8);
			return graphFormater.format(lines);
		} catch (FileNotFoundException e) {
			System.out.println("File not found by this URI");
			System.exit(1);
		} catch (IOException e) {
			System.out.println("Failed read file content");
			System.exit(1);
		}
		return null;
	}

}
