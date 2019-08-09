package com.Rahul;

import java.util.ArrayList;

public class Student {
	String name;
	ArrayList<String> preferenceList = new ArrayList<String>();
	public Student(ArrayList<String> list) {
		this.name = list.get(0);
		for(int i = 1 ; i < list.size() ; i++){
			preferenceList.add(list.get(i));
		}
	}

}
