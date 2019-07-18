
public interface IHexArithmetic {
	public String addTwoHexadecimalNums(String hexaDecimal1, String hexaDecimal2);
	
	public String subtractTwoHexadecimalNums(String hexaDecimal1, String hexaDecimal2);
	
	public String multiplyTwoHexadecimalNums(String hexaString1, String hexaString2);
	
	public String divideTwoHexadecimalNums(String hexaString1, String hexaString2);
	
	public int hexaDecimalToDecimal(String hexaDecimal);
	
	public String decimalToHexaDecimal(int decimal);
	
	public int hexaDecimalComparator(String hexaDecimal1, String hexaDecimal2);
	
	public void printIntroStatements();

}
