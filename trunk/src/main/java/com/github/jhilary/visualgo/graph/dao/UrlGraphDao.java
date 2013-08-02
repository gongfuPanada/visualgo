package com.github.jhilary.visualgo.graph.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;

import org.springframework.core.io.Resource;

import com.github.jhilary.visualgo.graph.Graph;
import com.github.jhilary.visualgo.graph.exception.GraphException;
import com.github.jhilary.visualgo.graph.formater.GraphFormater;

public class UrlGraphDao implements GraphDao{
	
	private Resource urlResource;
	private GraphFormater graphFormater;

	
	public void setUrlResource(Resource urlResource) {
		this.urlResource = urlResource;
	}
	
	public void setGraphFormater(GraphFormater graphFormater) {
		this.graphFormater = graphFormater;
	}

	@Override
	public Graph readGraph() throws GraphException {
		String result = "";
		String line = "";
		BufferedReader br = null;
		try{
			URL url = urlResource.getURL();
			br = new BufferedReader(new InputStreamReader(url.openStream(), Charset.forName("UTF-8")));
			while ((line = br.readLine()) != null){
				result += line + "\n";
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found by this URI");
			System.exit(1);
		} catch (IOException e) {
			System.out.println("Failed read file content");
			System.exit(1);
		}
		return graphFormater.format(result);
	}

}
