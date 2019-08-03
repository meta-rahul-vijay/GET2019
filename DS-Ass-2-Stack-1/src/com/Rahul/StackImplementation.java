package com.Rahul;

public class StackImplementation implements Stack{
	
	private String stackArray[] = new String[50];
	private int size = -1;
	
	@Override
	public void push(String element) {
		if(size == 50){
			return;
		}
		stackArray[++size] = element;
	}

	@Override
	public void pop() {
		if(this.isEmpty()){
			return;
		}
		size--;
	}

	@Override
	public String top() {
		if(!this.isEmpty()){
			return stackArray[size];
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		if(size == -1){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public void displayStack() {
		for(int i = 0 ; i <= size ; i++){
			System.out.print(stackArray[i] + " ");
		}
		System.out.println("");
	}

}
