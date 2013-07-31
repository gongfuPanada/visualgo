package com.github.jhilary.visualgo.mincut;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedList;

import com.github.jhilary.visualgo.graph.GraphException;
import com.github.jhilary.visualgo.graph.GraphUtil;
import com.github.jhilary.visualgo.graph.UndirectedGraph;

public class Main {

	public static void main(String[] args) {
		try {
			URL url3 = new URL("http://spark-public.s3.amazonaws.com/algo1/programming_prob/kargerMinCut.txt");
			String data3 = DataReader.readURLtoString(url3.openStream());
			InputStream is = new ByteArrayInputStream(data3.getBytes());
			HashMap<Integer, LinkedList<Integer>> graphData = DataReader.readGraph(is, "\t");
			is.close();
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
