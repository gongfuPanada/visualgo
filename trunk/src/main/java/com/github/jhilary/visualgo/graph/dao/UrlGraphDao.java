package com.github.jhilary.visualgo.graph.dao;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;

import org.springframework.core.io.Resource;

import com.github.jhilary.visualgo.graph.Graph;
import com.github.jhilary.visualgo.graph.exception.GraphException;
import com.github.jhilary.visualgo.graph.formater.GraphFormater;
import com.google.common.io.CharStreams;
import com.google.common.io.Resources;

public class UrlGraphDao implements GraphDao{
	
	private Resource urlResource;
	private GraphFormater graphFormater;

	public UrlGraphDao(Resource urlResource, GraphFormater graphFormater){
		this.urlResource = urlResource;
		this.graphFormater = graphFormater;
	}
	
	public void setUrlResource(Resource urlResource) {
		this.urlResource = urlResource;
	}
	
	public void setGraphFormater(GraphFormater graphFormater) {
		this.graphFormater = graphFormater;
	}

	@Override
	public Graph readGraph() throws GraphException {
		try{
			URL url = urlResource.getURL();
			List<String> text = CharStreams.readLines(Resources.newReaderSupplier(url, Charset.forName("UTF-8")));
			return graphFormater.format(text);
		} catch (IOException e) {
			System.out.println("Failed read url content");
			System.exit(1);
		}
		return null;
	}

}
