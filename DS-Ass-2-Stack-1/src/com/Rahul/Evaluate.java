package com.Rahul;

import java.util.*;

public class Evaluate {
	Map<String, Integer> mapOfPrecedence = new HashMap<String, Integer>();
	public int evaluateExpression(String str){
		if(str.isEmpty()){
			throw new AssertionError();
		}
		StackImplementation stack = new StackImplementation();
		str =  infixToPostfix(stack, str);
		String strArray[] = str.split(" ");
		for(int i = 0 ; i < strArray.length ; i++){
			if(!stack.isEmpty() && mapOfPrecedence.containsKey(strArray[i])){
				int second = Integer.parseInt(stack.top());
				stack.pop();
				int first = Integer.parseInt(stack.top());
				stack.pop();
				stack.push(Integer.toString(calculate(first, second, strArray[i])));
			}else{
				stack.push(strArray[i]);
			}
		}
		return Integer.parseInt(stack.top());
	}

	private int calculate(int first, int second, String operator) {
		if("+".equals(operator)){
			first = first + second;
		}else if("-".equals(operator)){
			first = first - second;
		}else if("*".equals(operator)){
			first = first * second;
		}else if("/".equals(operator)){
			first = first/second;
		}else if("%".equals(operator)){
			first = first % second;
		}
		return first;
	}

	public String infixToPostfix(StackImplementation stack, String str) {
		precedence();
		String postfixString = "";
		String strArray[] = str.split(" ");
		/*for(int i = 0 ; i < strArray.length ; i++){
			System.out.print(strArray[i] + " ");
		}*/
		for(int i = 0 ; i < strArray.length ; i++){
			if(i % 2 == 0){
				postfixString += strArray[i] + " ";
			}else{
				if(")".equals(strArray[i])){
					while(!stack.isEmpty() && !"(".equals(stack.top())){
						postfixString += stack.top() + " ";
						stack.pop();
					}
					stack.pop();
				}else if(stack.isEmpty() || mapOfPrecedence.get(stack.top()) < mapOfPrecedence.get(strArray[i])){
					stack.push(strArray[i]);
				}else if(mapOfPrecedence.get(stack.top()) >= mapOfPrecedence.get(strArray[i])){
					while(!stack.isEmpty() && mapOfPrecedence.get(stack.top()) >= mapOfPrecedence.get(strArray[i])){
						postfixString += stack.top() + " ";
						stack.pop();
					}
					stack.push(strArray[i]);
				}
			}
		}
		while(!stack.isEmpty()){
			postfixString += stack.top() + " ";
			stack.pop();
		}
		return postfixString;
	}

	private void precedence() {
		mapOfPrecedence.put(")", 0);
		mapOfPrecedence.put("+", 1);
		mapOfPrecedence.put("-", 1);
		mapOfPrecedence.put("*", 2);
		mapOfPrecedence.put("/", 2);
		mapOfPrecedence.put("%", 2);
		mapOfPrecedence.put("(", 3);
	}
}
