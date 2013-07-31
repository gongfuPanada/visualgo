package com.github.jhilary.visualgo.mincut;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Collections;
import java.util.Iterator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.junit.Assert.assertThat; 
import static org.hamcrest.CoreMatchers.*;


@RunWith(JUnit4.class)
public class testGraph {
	
	@Test
	public void testGraphConstruction() throws GraphException{
		   String str = 
				   	 "1 2 3 4\n" +
				     "2 1 3\n" +
				   	 "3 1 2 4\n" +
				     "4 1 3";
	 
		InputStream is = new ByteArrayInputStream(str.getBytes());
		Graph g = new Graph(DataReader.readGraph(is, " "));
		Collections.sort(g.getEdges());
		assertThat(g.getEdges().toString(), is("[[1,2], [1,3], [1,4], [2,3], [3,4]]"));
		assertThat(g.getNodes().toString(), is("{1=[[1,2], [1,3], [1,4]], 2=[[1,2], [2,3]], 3=[[1,3], [2,3], [3,4]], 4=[[1,4], [3,4]]}"));
	}

	@Test
	public void testRemoveEdge() throws GraphException{
		   String str = 
				   	 "1 2 3 4\n" +
				     "2 1 3\n" +
				   	 "3 1 2 4\n" +
				     "4 1 3";
		 
		InputStream is = new ByteArrayInputStream(str.getBytes());
		Graph g = new Graph(DataReader.readGraph(is, " "));
		Edge e = g.getEdges().getFirst();
		g.removeEdge(e);
		
		assertThat(g.getEdges().contains(e), is(false));
		assertThat(e.getFirst().getEdges().contains(e), is(false));
		assertThat(e.getSecond().getEdges().contains(e), is(false));
			}
	
	@Test
	public void testMergeEdge() throws GraphException{
		   String str = 
				   	 "1 2 3 4\n" +
				     "2 1 3\n" +
				   	 "3 1 2 4\n" +
				     "4 1 3";
		 
		InputStream is = new ByteArrayInputStream(str.getBytes());
		Graph g = new Graph(DataReader.readGraph(is, " "));
		
		Edge e = g.getEdges().getFirst();
		
		g.mergeEdge(e);
		assertThat(g.getEdges().contains(e), is(false));
		assertThat(e.getSecond().getEdges().contains(e), is(false));
		assertThat(g.getNodes().containsKey(e.getFirst().getLabel()), is(false));
		Iterator<Edge> iter = g.getEdges().iterator();
		while(iter.hasNext()){
			Edge edge = iter.next();
			assertThat(edge.contains(e.getFirst()), is(false));
		}
		assertThat(g.getNodes().containsKey(e.getFirst().getLabel()), is(false));		
	}

}
