package com.github.jhilary.visualgo.mincut;

import java.io.IOException;
import java.net.MalformedURLException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.jhilary.visualgo.dao.GraphDao;
import com.github.jhilary.visualgo.graph.GraphException;
import com.github.jhilary.visualgo.graph.GraphUtil;
import com.github.jhilary.visualgo.graph.UndirectedGraph;

public class Main {

	public static void main(String[] args) {
		try {
			ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("applicationContext.xml");
			GraphDao graphDao = (GraphDao) appContext.getBean("graphDao");
			appContext.close();
			UndirectedGraph graph = new UndirectedGraph(graphDao.readGraph());
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
