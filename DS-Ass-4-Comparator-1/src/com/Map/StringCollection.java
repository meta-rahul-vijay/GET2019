package com.Map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * The Class StringCollection.
 */
public class StringCollection {
	
	/** The map of unique character. */
	Map<String, Integer> mapOfUniqueCharacter = new HashMap<String, Integer>();
	
	/**
	 * Gets the unique character.
	 *
	 * @param str the str
	 * @return the unique character
	 */
	public int getUniqueCharacter(String str) {
		Set<Character> set = new HashSet<Character>();
		
		if(mapOfUniqueCharacter.containsKey(str)) {
			System.out.println("String Already Exists : "+str);
			return mapOfUniqueCharacter.get(str);
		}else {
			for(int i = 0 ; i < str.length() ; i++) {
				if(Character.isLowerCase(str.charAt(i)) && set.contains(Character.toUpperCase(str.charAt(i))) 
				|| (Character.isUpperCase(str.charAt(i)) && set.contains(Character.toLowerCase(str.charAt(i))))) {
					continue;
				}
				set.add(str.charAt(i));
			}
			mapOfUniqueCharacter.put(str, set.size());
			
			System.out.println("HashMap updated: "+ mapOfUniqueCharacter);
			return mapOfUniqueCharacter.get(str);
		}
	}
}
