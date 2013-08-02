package com.github.jhilary.dao.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

import com.github.jhilary.visualgo.dao.GraphDao;

public class StringGraphDao implements GraphDao {
	
	private String 	string;
	private String	delimiter;
	
	public void setString(String string) {
		this.string = string;
	}
	
	public void setDelimiter(String delimiter) {
		this.delimiter = delimiter;
	}
	
	@Override
	public HashMap<Integer, LinkedList<Integer>> readGraph(){
		HashMap<Integer, LinkedList<Integer>> result = new HashMap<Integer, LinkedList<Integer>>();
		LinkedList<Integer> l;
		String[] s = this.string.split("\n");
		for(int i = 0; i < s.length; i++){
			l = new LinkedList<Integer>();
			LinkedList<String> parsedLine = new LinkedList<String>(Arrays.asList(s[i].split(this.delimiter)));
			Iterator<String> iter = parsedLine.iterator();
			int key = Integer.valueOf(iter.next());
			while(iter.hasNext()){
				l.add(Integer.valueOf(iter.next()));
			}
			result.put(key, l);
		}
		return result;
	}
}
