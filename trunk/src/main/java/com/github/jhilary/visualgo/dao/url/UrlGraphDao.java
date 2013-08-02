package com.github.jhilary.visualgo.dao.url;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

import org.springframework.core.io.Resource;

import com.github.jhilary.visualgo.dao.GraphDao;

public class UrlGraphDao implements GraphDao{
	
	private Resource urlResource;
	private String	 delimiter;
	
	public void setUrl(Resource urlResource) {
		this.urlResource = urlResource;
	}
	
	public void setDelimiter(String delimiter) {
		this.delimiter = delimiter;
	}
	
	@Override
	public HashMap<Integer, LinkedList<Integer>> readGraph(){
		HashMap<Integer, LinkedList<Integer>> result = new HashMap<Integer, LinkedList<Integer>>();
		LinkedList<Integer> l;
		String line = "";
		BufferedReader br = null;
		try{
			URL url = urlResource.getURL();
			br = new BufferedReader(new InputStreamReader(url.openStream(), Charset.forName("UTF-8")));
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
