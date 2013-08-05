package com.github.jhilary.visualgo.graph.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.github.jhilary.visualgo.graph.Graph;
import com.github.jhilary.visualgo.graph.exception.GraphException;
import com.github.jhilary.visualgo.graph.formater.GraphFormater;

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
		StringBuilder result = new StringBuilder();
		String line = "";
		BufferedReader br = null;
		try{
			br = new BufferedReader(new FileReader(fileName));
			while ((line = br.readLine()) != null){
				result.append(line + "\n");
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found by this URI");
			System.exit(1);
		} catch (IOException e) {
			System.out.println("Failed read file content");
			System.exit(1);
		}
		return graphFormater.format(result.toString());
	}

}
