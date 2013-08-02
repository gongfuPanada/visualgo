package com.github.jhilary.visualgo.dao.url;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class UrlGraphDao {
	
	public static HashMap<Integer, LinkedList<Integer>> readGraph(InputStream stream, String delimiter){
		HashMap<Integer, LinkedList<Integer>> result = new HashMap<Integer, LinkedList<Integer>>();
		LinkedList<Integer> l;
		String line = "";
		BufferedReader br = null;
		try{
			br = new BufferedReader(new InputStreamReader(stream, Charset.forName("UTF-8")));
			while ((line = br.readLine()) != null){
				l = new LinkedList<Integer>();
				LinkedList<String> parsedLine = new LinkedList<String>(Arrays.asList(line.split(delimiter)));
				Iterator<String> iter = parsedLine.iterator();
				int key = Integer.valueOf(iter.next());
				while(iter.hasNext()){
					l.add(Integer.valueOf(iter.next()));
				}
				result.put(key, l);
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found by this URI");
			System.exit(1);
		} catch (IOException e) {
			System.out.println("Failed read file content");
			System.exit(1);
		}
		return result;
	}

}
