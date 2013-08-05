package com.github.jhilary.visualgo.graph;

public class Label implements Comparable<Label>{
	private Integer value;
	public boolean explored;
	public Integer leader;
	public Integer time;

	public Label(int n){
		this.value = n;
		this.leader = n;
		this.time = 0;
		this.explored = false;
	}

	public int getValue(){
		return value;
	}
	
	@Override
	public String toString() {
		return String.valueOf(value);
	}

	@Override
	public int compareTo(Label o) {
		return value.compareTo(o.getValue());
	}
	
	@Override
	public boolean equals(Object o) {
		if (o != null && o.getClass() == this.getClass()) {
			return this.value == ((Label)o).getValue();
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return this.value.hashCode();
	}
}
