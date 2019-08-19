package com.Molecule;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class OrganicCompound {
	Map<Character, Integer> elementToMassMap = new HashMap<Character, Integer>(); 
	String compound = new String();

	public OrganicCompound(String compound) {
		super();
		this.compound = compound;
		elementToMassMap.put('C', 12);
		elementToMassMap.put('O', 16);
		elementToMassMap.put('H', 1);
	}	
	public int getMassOfCompound(){
		Stack<String> stack = new Stack<>();
		
		for(int i = 0 ; i < compound.length() ; i++){
			if(elementToMassMap.containsKey(compound.charAt(i))){
				stack.push(elementToMassMap.get(compound.charAt(i)).toString());
			}else if(compound.charAt(i) == '('){
				stack.push(String.valueOf(compound.charAt(i)));
			}else if(compound.charAt(i) == ')'){
				int sum = 0;
				while(!stack.isEmpty() && !stack.peek().equals(String.valueOf('('))){
					String top = stack.pop();
					sum += Integer.parseInt(top);
				}
				stack.pop();
				stack.push(String.valueOf(sum));
			}else if(Character.isDigit(compound.charAt(i))){
				int value = 0;
				while(i < compound.length() && Character.isDigit(compound.charAt(i))){
					value = value * 10 + Character.getNumericValue(compound.charAt(i)) ;
					i++;
				}
				String top = stack.pop();
				top = String.valueOf(Integer.valueOf(top) * value);
				stack.push(top);
				i--;
			}
		}
		int totalMass = 0;
		while(!stack.isEmpty()){
			totalMass += Integer.parseInt(stack.pop());
		}
		return totalMass;
	}
	
}
