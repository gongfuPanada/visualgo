package com.github.jhilary.visualgo.dao;

import java.util.HashMap;
import java.util.LinkedList;

public interface GraphDao {
	HashMap<Integer, LinkedList<Integer>> readGraph();
}
