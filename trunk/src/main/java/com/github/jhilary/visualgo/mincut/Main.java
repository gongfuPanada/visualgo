package com.github.jhilary.visualgo.mincut;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.jhilary.visualgo.dao.GraphDao;
import com.github.jhilary.visualgo.graph.Graph;
import com.github.jhilary.visualgo.graph.GraphException;

public class Main {

	public static void main(String[] args) {
		try {
			ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
			GraphDao graphDao = (GraphDao) appContext.getBean("graphDao");
			appContext.close();
			Graph graph = graphDao.readGraph();
			
			System.out.println("Data downloaded");
			
			long startTime = System.nanoTime();
			System.out.println("Mincut value: " + graph.minCut());
			System.out.println("Time for 1000 iterations: " + (((System.nanoTime() - startTime))/1000000000));
			
		} catch (GraphException e) {
			System.out.println("MinCut problems: " + e.getMessage());
			System.exit(1);
		}
	}
}
