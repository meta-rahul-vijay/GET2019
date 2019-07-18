import java.util.Scanner;


public class HexCalc {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		String hexaDecimal1 = null;
		String hexaDecimal2 = null;
		HexArithmetic hexArithmetic = new HexArithmetic();
		hexArithmetic.printIntroStatements();
		while(true){
			System.out.println("\nEnter Choice");
		int choice = sc.nextInt();
		switch(choice){
		case 1 : 
			hexaDecimal1 = sc.next();
			hexaDecimal2 = sc.next();
			System.out.println(hexArithmetic.addTwoHexadecimalNums(hexaDecimal1, hexaDecimal2));
			break;
		
		case 2 : 
			hexaDecimal1 = sc.next();
			hexaDecimal2 = sc.next();
			System.out.println(hexArithmetic.subtractTwoHexadecimalNums(hexaDecimal1, hexaDecimal2));
			break;
			
		case 3 : 
			hexaDecimal1 = sc.next();
			hexaDecimal2 = sc.next();
			System.out.println(hexArithmetic.multiplyTwoHexadecimalNums(hexaDecimal1, hexaDecimal2));
			break;
			
		case 4 : 
			hexaDecimal1 = sc.next();
			hexaDecimal2 = sc.next();
			System.out.println(hexArithmetic.divideTwoHexadecimalNums(hexaDecimal1, hexaDecimal2));
			break;
			
		case 5 : 
			hexaDecimal1 = sc.next();
			System.out.println(hexArithmetic.hexaDecimalToDecimal(hexaDecimal1));
			break;
			
		case 6 : 
			hexaDecimal1 = sc.next();
			System.out.println(hexArithmetic.decimalToHexaDecimal(Integer.parseInt(hexaDecimal1)));
			break;
		
		case 7 : 
			hexaDecimal1 = sc.next();
			hexaDecimal1 = sc.next();
			System.out.println(hexArithmetic.hexaDecimalComparator(hexaDecimal1, hexaDecimal2));
			break;
			
		case 8 : 
			System.out.println("\n" + "Good Bye");
	            System.exit(0);
			}
		}
	}
}
