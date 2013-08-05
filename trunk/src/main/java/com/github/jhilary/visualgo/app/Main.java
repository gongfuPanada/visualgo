package com.github.jhilary.visualgo.app;

import java.net.MalformedURLException;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.UrlResource;

import com.github.jhilary.visualgo.graph.Graph;
import com.github.jhilary.visualgo.graph.algorithm.StrongConnectedComponents;
import com.github.jhilary.visualgo.graph.dao.FileGraphDao;
import com.github.jhilary.visualgo.graph.dao.GraphDao;
import com.github.jhilary.visualgo.graph.dao.UrlGraphDao;
import com.github.jhilary.visualgo.graph.exception.GraphException;
import com.github.jhilary.visualgo.graph.factory.UndirectedGraphFactory;
import com.github.jhilary.visualgo.graph.formater.DirectedGraphFormater;

public class Main {

	public static void main(String[] args) {
		try {
//			ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//			GraphDao graphDao = (GraphDao) appContext.getBean("graphDao");
//			appContext.close();
//			Graph graph = graphDao.readGraph();
//			
			UndirectedGraphFactory graphFactory = new UndirectedGraphFactory();
			DirectedGraphFormater graphFormater = new DirectedGraphFormater(graphFactory);
			FileGraphDao dao = new FileGraphDao("/Users/ilariyabelova/SCC.txt", graphFormater);
			long startTime = System.nanoTime();
			System.out.println("Data start download");
			Graph g = dao.readGraph();
			System.out.println("Data end download");
			
			System.out.println(g.getNodes().get(1).getEdges().get(0));
			StrongConnectedComponents algo = new StrongConnectedComponents(g);
			algo.run();
			//System.out.println(g.getEdges());
			
			//System.out.println("Mincut value: " + graph.minCut());
			System.out.println("Time for 1000 iterations: " + (((System.nanoTime() - startTime))/1000000000));

		} catch (GraphException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
