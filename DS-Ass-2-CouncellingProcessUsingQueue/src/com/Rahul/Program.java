package com.Rahul;

public class Program {
	String programName;
	int capacity;
	int currentSize;
	
	public Program(String programName, int capacity, int currentSize) {
		super();
		this.programName = programName;
		this.capacity = capacity;
		this.currentSize = 0;
	}
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getCurrentSize() {
		return currentSize;
	}
	public void setCurrentSize(int currentSize) {
		this.currentSize = currentSize;
	}
	
}
