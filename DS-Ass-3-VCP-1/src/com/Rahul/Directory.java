package com.Rahul;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Directory {
	Node root = new Node("R:");
	Node cur = root;
	public void makeDirectory(String directoryName){
		Node newNode = new Node("/"+ directoryName);
		cur.getListOfNode().add(newNode);
	}
	
	public void changeDirectory(String directoryName){
		String[] nestedDirectory = directoryName.split("/");
		for(int i= 0 ; i < nestedDirectory.length ; i++){
			nestedDirectory[i] = "/" + nestedDirectory[i];
		}
		int i = 0;
		try{
			while(nestedDirectory[i] != null){
				ArrayList<Node> listOfNode = cur.getListOfNode();
				for(int j = 0 ; j < listOfNode.size() ; j++){
					if(listOfNode.get(j).getData().equalsIgnoreCase(nestedDirectory[i])){
						//listOfNode = listOfNode.get(j).getListOfNode(); change for multiple directory switch
						cur = listOfNode.get(j);
						return;
					}
				}
				i++;
			}
		}catch(RuntimeException e){
			throw new RuntimeException("directory not present");
		}
	}
	
	public void back(){
		if(cur == root){
			throw new RuntimeException("This is a root directory");
		}
	    Queue<Node> queue = new LinkedList<>();
	   
		for(int j = 0 ; j < root.getListOfNode().size(); j++){
			queue.add(root.getListOfNode().get(j));
			if(cur == root.getListOfNode().get(j)){
				cur = root;
				return;
			}
		}
		while(!queue.isEmpty()){
			Node temp = queue.remove();
			for(int k = 0 ; k < temp.getListOfNode().size(); k++){
				queue.add(temp.getListOfNode().get(k));
				if(cur == temp.getListOfNode().get(k)){
					cur = temp;
					return;
				}
			}
		}
	}
	
	public void listDirectory(){
		 ArrayList<Node> listOfNode = cur.getListOfNode();
		 if(listOfNode == null){
			 throw new RuntimeException("Empty Directory");
		 }
		 for(int i = 0 ; i < listOfNode.size() ; i++){
			 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			 LocalDateTime now = LocalDateTime.now();  
			 System.out.println(dtf.format(now) + "  "+listOfNode.get(i).data);  
		 }
		 System.out.println("Folders = "+listOfNode.size());
	}
	
	public String[] find(String directoryName){
		ArrayList<Node> listOfNode = cur.getListOfNode();
		Queue<Node> queue = new LinkedList<>();
		String[] folders = new String[100];
		int count = 0;
		int level = 0;
		folders[level] = "";
		for(int i = 0 ; i < listOfNode.size() ; i++){
			queue.add(listOfNode.get(i));
		}
		queue.add(null);
		while(!queue.isEmpty()){
			Node temp = queue.remove();
			if(temp == null && queue.peek() != null){
				level++;
				continue;
			}else if(temp == null && queue.peek() == null){
				return folders;
			}
			
			for(int k = 0 ; k < temp.getListOfNode().size(); k++){
				queue.add(temp.getListOfNode().get(k));
			}
			if(temp.getListOfNode().size() != 0){
				queue.add(null);
			}
			folders[++count] = folders[level] + temp.data;
		}
		return folders;
	}
	
	public void print(){
		Queue<Node> queue = new LinkedList<>();
		ArrayList<Node> listOfNode = cur.getListOfNode();
		int level = 0;
		for(int i = 0 ; i < listOfNode.size() ; i++){
			queue.add(listOfNode.get(i));
			System.out.println("Sub directory of "+cur.data + " : "+listOfNode.get(i).data);
		}
		queue.add(null);
		while(queue != null){
			Node temp = queue.remove();
			if(temp == null && queue.peek() != null){
				level++;
				continue;
			}else if(temp == null && queue.peek() == null){
				return;
			}
			
			for(int k = 0 ; k < temp.getListOfNode().size(); k++){
				queue.add(temp.getListOfNode().get(k));
				System.out.println("Sub directory of "+temp.data + " : "+temp.getListOfNode().get(k).data);
			}
			if(temp.getListOfNode().size() != 0){
				queue.add(null);
			}
		}
	}
	
}
