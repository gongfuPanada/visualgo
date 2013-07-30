package com.github.jhilary.visualgo.mincut;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {

	public static void main(String[] args) {
		try {
			URL url3 = new URL("http://spark-public.s3.amazonaws.com/algo1/programming_prob/kargerMinCut.txt");
			String data3 = DataReader.readURLtoString(url3.openStream());
			System.out.println("Data downloaded");
			System.out.println(GraphUtil.minCut(data3, "\t"));
		} catch (MalformedURLException e) {
			System.out.println("MalFormed URL");
			System.exit(1);
		} catch (IOException e) {
			System.out.println("Cannot read data by URL");
			System.exit(1);
		}
	}
}
