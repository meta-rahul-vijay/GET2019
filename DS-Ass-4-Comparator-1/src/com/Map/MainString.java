package com.Map;

// TODO: Auto-generated Javadoc
/**
 * The Class MainString.
 */
public class MainString {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String args[]) {
		StringCollection stringCollection = new StringCollection();
		String s1 = new String("Bumrah");
		String s2 = new String("Virat");
		String s3 = new String("Jadeja");
		String s4 = new String("ShiKhar");
		String s5 = new String("VVS Laxman");
		
		System.out.println(stringCollection.getUniqueCharacter(s1));
		System.out.println(stringCollection.getUniqueCharacter(s2));
		System.out.println(stringCollection.getUniqueCharacter(s3));
		System.out.println(stringCollection.getUniqueCharacter(s4));
		System.out.println(stringCollection.getUniqueCharacter(s5));
		System.out.println(stringCollection.getUniqueCharacter(s3));
	}
}
