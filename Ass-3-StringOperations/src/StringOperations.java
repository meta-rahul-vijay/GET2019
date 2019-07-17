import java.util.ArrayList;


// TODO: Auto-generated Javadoc
/**
 * The Class StringOperations.
 */
public class StringOperations {

	/**
	 * Compare strings.
	 *
	 * @param str1 the str 1
	 * @param str2 the str 2
	 * @return true, if successful
	 */
	public boolean compareStrings(String str1, String str2) {
		int strlen1 = strLength(str1);
		int strlen2 = strLength(str2);
		if(strlen1 == strlen2){
			str1 += '\0';
			str1 += '\0';
			int i = 0;
			while(str1.charAt(i) == str2.charAt(i)){
				i++;
				if(str1.charAt(i) == '\0' && str2.charAt(i) == '\0'){
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Str length.
	 *
	 * @param str1 the str 1
	 * @return the int
	 */
	private int strLength(String str1) {
		// TODO Auto-generated method stub
		
		str1 += '\0';
		int length = 0; 
		while(str1.charAt(length) != '\0'){
			length++;
		}
		return length;
	}

	/**
	 * Reverse string.
	 *
	 * @param str the str
	 * @return the string
	 */
	public String reverseString(String str) {
		for(int i = 0, j = strLength(str)-1 ; i<j ; i++,j--){
			char temp = str.charAt(i);
			str = str.substring(0, i) + str.charAt(j) + str.substring(i + 1); 
			str = str.substring(0, j) + temp + str.substring(j + 1);
		}
		return str;
	}
	
	/**
	 * Replace lower to upper case and vice versa.
	 *
	 * @param str the str
	 * @return the string
	 */
	public String replaceLowerToUpperCaseAndViceVersa(String str){
		int i=0;
		while(i < strLength(str)){
			if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z'){
				str = str.substring(0, i) + (char)(str.charAt(i)-32) + str.substring(i + 1); 
			}
			else if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z'){
				str = str.substring(0, i) + (char)(str.charAt(i)+32) + str.substring(i + 1);
			}
			i++;
		}
		return str;
	}
	
	/**
	 * Largest word of string.
	 *
	 * @param str the str
	 * @return the string
	 */
	public String largestWordOfString(String str){
		ArrayList<String> words = new ArrayList<String>();
		String word = "";
		String maxLengthWord = "";
		str = str + " ";
		//for splitting words
		for(int i = 0; i < strLength(str); i++){    
			if(str.charAt(i) != ' '){    
				word = word + str.charAt(i);    
			}    
			else{    
				words.add(word);        
				word = "";    
			}    
		}
		//for finding largest word
		for(int i = 0; i < words.size(); i++){
            if(strLength(words.get(i)) >= strLength(maxLengthWord)){
            	maxLengthWord = words.get(i);
            } 
		}
		return maxLengthWord;
	}

	/**
	 * Show instructions.
	 */
	public void showInstructions() {
		// TODO Auto-generated method stub
		System.out.println("1: Compare Strings");
		System.out.println("2: Reverse String");
		System.out.println("3: Convert LowerTo Upper Case and Vice Versa");
		System.out.println("4: Largest Word of String");
		System.out.println("Press Any Number: Exit");
	}
}
