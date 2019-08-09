package com.Rahul;

import java.util.ArrayList;

public class Node {
	String data;
	ArrayList<Node> listOfNode = new ArrayList<>();
	
	public Node(String data) {
		this.data = data;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public ArrayList<Node> getListOfNode() {
		return listOfNode;
	}
	public void setListOfNode(ArrayList<Node> listOfNode) {
		this.listOfNode = listOfNode;
	}
	
}
