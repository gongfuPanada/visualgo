package com.github.jhilary.visualgo.graph;

import java.util.Collections;
import java.util.Iterator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.github.jhilary.visualgo.graph.Edge;
import com.github.jhilary.visualgo.graph.dao.StringGraphDao;
import com.github.jhilary.visualgo.graph.exception.GraphException;
import com.github.jhilary.visualgo.graph.factory.UndirectedGraphFactory;
import com.github.jhilary.visualgo.graph.formater.NodeGraphFormater;

import static org.junit.Assert.assertThat; 
import static org.hamcrest.CoreMatchers.*;


@RunWith(JUnit4.class)
public class TestGraph {
	
	@Test
	public void testGraphConstruction() throws GraphException{
		   String str = 
				   	 "1 2 3 4\n" +
				     "2 1 3\n" +
				   	 "3 1 2 4\n" +
				     "4 1 3";	 
		UndirectedGraphFactory graphFactory = new UndirectedGraphFactory();
		NodeGraphFormater graphFormater = new NodeGraphFormater();
		graphFormater.setDelimiter(" ");
		graphFormater.setGraphFactory(graphFactory);
		StringGraphDao graphDao = new StringGraphDao();
		graphDao.setString(str);
		graphDao.setGraphFormater(graphFormater);
		Graph g = graphDao.readGraph();
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
		 
		UndirectedGraphFactory graphFactory = new UndirectedGraphFactory();
		NodeGraphFormater graphFormater = new NodeGraphFormater();
		graphFormater.setDelimiter(" ");
		graphFormater.setGraphFactory(graphFactory);
		StringGraphDao graphDao = new StringGraphDao();
		graphDao.setString(str);
		graphDao.setGraphFormater(graphFormater);
		Graph g = graphDao.readGraph();
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
		 
		UndirectedGraphFactory graphFactory = new UndirectedGraphFactory();
		NodeGraphFormater graphFormater = new NodeGraphFormater();
		graphFormater.setDelimiter(" ");
		graphFormater.setGraphFactory(graphFactory);
		StringGraphDao graphDao = new StringGraphDao();
		graphDao.setString(str);
		graphDao.setGraphFormater(graphFormater);
		Graph g = graphDao.readGraph();
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
