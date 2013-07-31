package com.github.jhilary.visualgo.graph;

import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;

public class GraphUtil {

	private static int minCutIteration(UndirectedGraph g){
		Collections.shuffle(g.getEdges());
		while(g.getNodes().size() != 2 && g.getEdges().size() != 0){
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
	 public static int minCut(UndirectedGraph graph) throws IOException, GraphException{

		UndirectedGraph workGraph;
		int min = Integer.MAX_VALUE;
		long startTime = System.nanoTime();
		for(int i = 0 ; i < 1000; i++){
			workGraph = new UndirectedGraph(graph);
			int res = minCutIteration(workGraph);
			if(res < min){
				min = res;
			}
		}
		System.out.println("Mincut value: " + min);

		System.out.println("Time for 1000 iterations: " + (((System.nanoTime() - startTime))/1000000000));
		return min;

	 }

}
