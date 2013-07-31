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
			Collections.shuffle(g.getEdges());
			
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
			Graph g;
			try {
				g = new Graph(graphData);
				is.close();
				int min = Integer.MAX_VALUE;
				long startTime = System.nanoTime();
				for(int i = 0 ; i < 100; i++){
					System.out.println("Mincut iteration #" + i + " of " + 100);
					int res = minCutIteration(g);
					if(res < min){
						min = res;
					}
					is = new ByteArrayInputStream(data.getBytes());
					graphData = DataReader.readGraph(is, delimiter);
					g = new Graph(graphData);
					is.close();
					System.out.println("mincut: " + res + "; global min: " + min);
				}
				System.out.println("Time for 100 iterations: " + (((System.nanoTime() - startTime))/1000000000));
				return min;
			} catch (GraphException e) {
				throw new GraphException("Bad graph input data: " + e.getMessage());
			}
	 }

}
