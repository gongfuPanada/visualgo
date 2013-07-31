package com.github.jhilary.visualgo.mincut;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;


public class GraphUtil {

	private static int minCutIteration(Graph g){
		Collections.shuffle(g.getEdges());
		while(g.getNodesSize() != 2 && g.getEdges().size() != 0){
			Edge edge = g.getEdges().getFirst();
			g.mergeEdge(edge);
		}
		int mincut = 0;
		Node first = g.getNodes().get(g.getNodes().keySet().iterator().next());
		Iterator<Edge> mincutEdges = first.getEdges().iterator();
		while(mincutEdges.hasNext()){
			Edge e = mincutEdges.next();
			if(e.getFirst() != e.getSecond()){
				mincut++;
			}
		}
		return mincut;
	}
	 public static int minCut(String data, String delimiter) throws IOException, GraphException{
			InputStream is = new ByteArrayInputStream(data.getBytes());
			HashMap<Integer, LinkedList<Integer>> graphData = DataReader.readGraph(is, delimiter);
			Graph baseGraph = new Graph(graphData);
			is.close();
			Graph workGraph;
			int min = Integer.MAX_VALUE;
			long startTime = System.nanoTime();
			for(int i = 0 ; i < 10000; i++){
				System.out.println("Mincut iteration #" + i + " of " + 10000);
				workGraph = baseGraph.clone();
				int res = minCutIteration(workGraph);
				if(res < min){
					min = res;
				}
				is = new ByteArrayInputStream(data.getBytes());
				is.close();
				System.out.println("mincut: " + res + "; global min: " + min);
			}
			System.out.println("Time for 10000 iterations: " + (((System.nanoTime() - startTime))/1000000000));
			return min;

	 }

}
