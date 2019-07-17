import java.util.Scanner;


// TODO: Auto-generated Javadoc
/**
 * The Class Strings.
 */
public class Strings {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String args[]){
		System.out.println("Strings Operations");
		Scanner sc = new Scanner(System.in);
		StringOperations stringOpr = new StringOperations();
		stringOpr.showInstructions();
		
		while(true){
			String str1 = "";
			String str2 = "";
			System.out.println("\nEnter Choice");
			int choice = sc.nextInt();
			sc.nextLine();
			switch(choice){
			   case 1 : 
				   str1 = sc.nextLine();
				   //sc.nextLine();
				   str2 = sc.nextLine();
				   System.out.println(stringOpr.compareStrings(str1,str2));
			       break;
			   
			   case 2 : 
				   //sc.nextLine();
				   str1 = sc.nextLine();
				   System.out.println(stringOpr.reverseString(str1));
			       break;
			   
			   case 3 :
				   //sc.nextLine();
				   str1 = sc.nextLine();
				   System.out.println(stringOpr.replaceLowerToUpperCaseAndViceVersa(str1));
			       break;
			   
			   case 4 :
				   //sc.nextLine();
				   str1 = sc.nextLine();
				   System.out.println(stringOpr.largestWordOfString(str1));
				   break;
			   
			   default :
				   System.out.println("\n" + "Good Bye");
		           System.exit(0);
			}	
		}
	}
}
