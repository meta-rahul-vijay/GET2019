import java.util.Scanner;

// class for perform all operations of calculator
public class HexArithmetic implements IHexArithmetic {
	private int decimal1;
	private int decimal2;
	private int additionOfHexa;
	private int subtractionOfHexa;
	private int multiplicationOfHexa;
	private int divisionOfHexa;
	
// method for add two hexadecimal numbers
public String addTwoHexadecimalNums(String hexaDecimal1, String hexaDecimal2){
	this.decimal1 = hexaDecimalToDecimal(hexaDecimal1);
	this.decimal2 = hexaDecimalToDecimal(hexaDecimal2);
	this.additionOfHexa = this.decimal1 + this.decimal2;
	return decimalToHexaDecimal(this.additionOfHexa);  
}
// method for subtract two hexadecimal numbers
public String subtractTwoHexadecimalNums(String hexaDecimal1, String hexaDecimal2){
	this.decimal1 = hexaDecimalToDecimal(hexaDecimal1);
	this.decimal2 = hexaDecimalToDecimal(hexaDecimal2);
	this.subtractionOfHexa = this.decimal1 - this.decimal2;
	return decimalToHexaDecimal(this.subtractionOfHexa); 
}
// method for multiply two hexadecimal numbers
public String multiplyTwoHexadecimalNums(String hexaString1, String hexaString2){
	this.decimal1 = Integer.parseInt(hexaString1,16);
	this.decimal2 = Integer.parseInt(hexaString2,16);
	this.multiplicationOfHexa = (this.decimal1 * this.decimal2);
	return decimalToHexaDecimal(this.multiplicationOfHexa); 	
}
// method for divide two hexadecimal numbers
public String divideTwoHexadecimalNums(String hexaString1, String hexaString2){
	this.decimal1 = Integer.parseInt(hexaString1,16);
	this.decimal2 = Integer.parseInt(hexaString2,16);
	this.divisionOfHexa = (this.decimal1/this.decimal2);
	return decimalToHexaDecimal(this.divisionOfHexa); 	
}
// method for covert hexaDecimal to decimal
public int hexaDecimalToDecimal(String hexaDecimal){
    int len = hexaDecimal.length(); 
    int base = 1; 
    int decimalValue = 0; 
    for (int i=len-1; i>=0; i--) 
    {    
        if (hexaDecimal.charAt(i)>='0' && hexaDecimal.charAt(i)<='9') 
        { 
            decimalValue += (hexaDecimal.charAt(i) - 48)*base;  
            base = base * 16; 
        } 
        else if (hexaDecimal.charAt(i)>='A' && hexaDecimal.charAt(i)<='F') 
        { 
            decimalValue += (hexaDecimal.charAt(i) - 55)*base; 
            base = base*16; 
        } 
    }
    return decimalValue; 
}
// method for covert decimal to hexadecimal
public String decimalToHexaDecimal(int decimal){
	String hexaDeciNum = "";
    int i = 0; 
    while(decimal!=0) 
    {    
        int temp  = 0; 
        temp = decimal % 16; 
        if(temp < 10) 
        { 
            hexaDeciNum += (char)(temp + 48); 
            i++; 
        } 
        else
        { 
            hexaDeciNum += (char)(temp + 55); 
            i++; 
        } 
       
        decimal = decimal/16; 
    } 
	
	return hexaDeciNum;
}
// method for compare two hexadecimal numbers
public int hexaDecimalComparator(String hexaDecimal1, String hexaDecimal2){
	return hexaDecimal1.compareTo(hexaDecimal2);
}
// method for print introduction statements
public void printIntroStatements(){
	System.out.println("Hexa Calculator");
	System.out.println("\nChoose Option");
	System.out.println("\n1 for add two Hexadecimal Numbers");
	System.out.println("2 for subtract two Hexadecimal Numbers");
	System.out.println("3 for multiply two Hexadecimal Numbers");
	System.out.println("4 for divide two Hexadecimal Numbers");
	System.out.println("5 for convert Hexadecimal to Decimal");
	System.out.println("6 for convert Decimal to Hexadecimal");
	System.out.println("7 for compare two hexadecimal numbers");
	System.out.println("8 Exit");
	}
}
