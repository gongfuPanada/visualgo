package com.github.jhilary.visualgo.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.jhilary.visualgo.graph.Graph;
import com.github.jhilary.visualgo.graph.dao.GraphDao;
import com.github.jhilary.visualgo.graph.exception.GraphException;

public class Main {

	public static void main(String[] args) {
		try {
			ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
			GraphDao graphDao = (GraphDao) appContext.getBean("graphDao");
			appContext.close();
			Graph graph = graphDao.readGraph();
			
			long startTime = System.nanoTime();
			System.out.println("Mincut value: " + graph.minCut());
			System.out.println("Time for 1000 iterations: " + (((System.nanoTime() - startTime))/1000000000));

//			UndirectedGraphFactory graphFactory = new UndirectedGraphFactory();
//			DirectedGraphFormater graphFormater = new DirectedGraphFormater(graphFactory);
//			FileGraphDao dao = new FileGraphDao("/Users/ilariyabelova/SCC.txt", graphFormater);
//			long startTime = System.nanoTime();
//			System.out.println("Data start download");
//			Graph g = dao.readGraph();
//			dao = null;
//			System.out.println("Data end download");
//			System.out.println("Data loaded: " + (((System.nanoTime() - startTime))/1000000000));
			//System.out.println(g.getNodes().get(1).getEdges().get(0));
//			StrongConnectedComponents algo = new StrongConnectedComponents(g);
//			algo.run();
//			System.out.println(g.getEdges());
			
		} catch (GraphException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
