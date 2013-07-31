package com.github.jhilary.visualgo.mincut;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.github.jhilary.visualgo.graph.GraphException;

@RunWith(value = Parameterized.class)
public class TestMinCut {
	 private String string;
	 private int mincuts;
	 
	 public TestMinCut(String string, int mincuts) {
	    this.string = string;
	    this.mincuts = mincuts;
	 }

	 @Parameters
	 public static Collection<Object[]> data() {
	   List<Object[]> expectedTestData = new LinkedList<Object[]>();
       
       //Doesn't throw exceptions
	   String str = 
			   	 "1 2 3 4\n" +
			     "2 1 3\n" +
			   	 "3 1 2 4\n" +
			     "4 1 3";
       expectedTestData.add(new Object[]{str, new Integer(2)});
       
	   str = 
			   	 "1 2 3 4 5\n" +
			     "2 1 3 4 5\n" +
			   	 "3 1 2 4 5\n" +
			     "4 1 2 3 5\n" +
			     "5 1 2 3 4\n";
       expectedTestData.add(new Object[]{str, new Integer(4)});
	   
       str = 
			   	 "1 2 4\n" +
			     "2 1 4 3\n" +
			   	 "3 2 4\n" +
			     "4 1 3 2";
     expectedTestData.add(new Object[]{str, new Integer(2)});
       //Doesn't throw exceptions
	   str = 
			   	 "1 2 3 4 7\n"+
				 "2 1 3 4\n" +
				 "3 1 2 4\n" +
				 "4 1 2 3 5\n" +
				 "5 4 6 7 8\n" +
				 "6 5 7 8\n" +
				 "7 1 5 6 8\n" +
				 "8 5 6 7\n";
       expectedTestData.add(new Object[]{str, new Integer(2)});
       str = 
    		   "1 4 2 7 3\n" +
    		   "2 4 1 3\n" +
    		   "3 1 2 4\n" +
    		   "4 5 1 2 3\n" +
    		   "5 8 7 6 4\n" +
    		   "6 8 5 7\n" +
    		   "7 6 8 5 1\n" +
    		   "8 7 6 5";
       expectedTestData.add(new Object[]{str, new Integer(2)});
       str = 
    		   "1 2 3 4\n" +
    		   "2 1 3 4\n" +
    		   "3 1 2 4\n" +
    		   "4 1 2 3 5\n" +
    		   "5 4 6 7 8\n" +
    		   "6 5 7 8\n" +
    		   "7 5 6 8\n" +
    		   "8 5 6 7";
       expectedTestData.add(new Object[]{str, new Integer(1)});
       str =
    		   "1 19 15 36 23 18 39\n" + 
    		   "2 36 23 4 18 26 9\n" +
    		   "3 35 6 16 11\n" +
    		   "4 23 2 18 24\n" +
    		   "5 14 8 29 21\n" +
    		   "6 34 35 3 16\n" +
    		   "7 30 33 38 28\n" +
    		   "8 12 14 5 29 31\n" +
    		   "9 39 13 20 10 17 2\n" +
    		   "10 9 20 12 14 29\n" +
    		   "11 3 16 30 33 26\n" +
    		   "12 20 10 14 8\n" +
    		   "13 24 39 9 20\n" +
    		   "14 10 12 8 5\n" +
    		   "15 26 19 1 36\n" +
    		   "16 6 3 11 30 17 35 32\n" +
    		   "17 38 28 32 40 9 16\n" +
    		   "18 2 4 24 39 1\n" +
    		   "19 27 26 15 1\n" +
    		   "20 13 9 10 12\n" +
    		   "21 5 29 25 37\n" +
    		   "22 32 40 34 35\n" +
    		   "23 1 36 2 4\n" +
    		   "24 4 18 39 13\n" +
    		   "25 29 21 37 31\n" +
    		   "26 31 27 19 15 11 2\n" +
    		   "27 37 31 26 19 29\n" +
    		   "28 7 38 17 32\n" +
    		   "29 8 5 21 25 10 27\n" +
    		   "30 16 11 33 7 37\n" +
    		   "31 25 37 27 26 8\n" +
    		   "32 28 17 40 22 16\n" +
    		   "33 11 30 7 38\n" +
    		   "34 40 22 35 6\n" +
    		   "35 22 34 6 3 16\n" +
    		   "36 15 1 23 2\n" +
    		   "37 21 25 31 27 30\n" +
    		   "38 33 7 28 17 40\n" +
    		   "39 18 24 13 9 1\n" +
    		   "40 17 32 22 34 38";
       expectedTestData.add(new Object[]{str, new Integer(3)});
       return expectedTestData;
	 }
	 
	 @Test
	 public void testMinCut() throws IOException, GraphException{
		 int min = GraphUtil.minCut(this.string, " ");
		 assertEquals("Mincut doesn't converge right:", this.mincuts, min);
	 }

}
