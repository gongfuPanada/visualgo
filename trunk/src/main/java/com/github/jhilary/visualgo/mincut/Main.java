package com.github.jhilary.visualgo.mincut;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedList;

import org.springframework.core.io.UrlResource;

import com.github.jhilary.visualgo.dao.url.UrlGraphDao;
import com.github.jhilary.visualgo.graph.GraphException;
import com.github.jhilary.visualgo.graph.GraphUtil;
import com.github.jhilary.visualgo.graph.UndirectedGraph;

public class Main {

	public static void main(String[] args) {
		try {
			URL url3 = new URL("http://spark-public.s3.amazonaws.com/algo1/programming_prob/kargerMinCut.txt");
			UrlGraphDao g = new UrlGraphDao();
			g.setUrl(new UrlResource(url3));
			g.setDelimiter("\t");
			HashMap<Integer, LinkedList<Integer>> graphData = g.readGraph();
			UndirectedGraph graph = new UndirectedGraph(graphData);
			System.out.println("Data downloaded");
			System.out.println(GraphUtil.minCut(graph));
		} catch (MalformedURLException e) {
			System.out.println("MalFormed URL");
			System.exit(1);
		} catch (IOException e) {
			System.out.println("Cannot read data by URL");
			System.exit(1);
		} catch (GraphException e) {
			System.out.println("MinCut problems: " + e.getMessage());
			System.exit(1);
		}
	}
}
