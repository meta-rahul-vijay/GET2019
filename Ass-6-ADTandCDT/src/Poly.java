import java.util.Scanner;
import java.lang.Math; 

// TODO: Auto-generated Javadoc
/**
 * author : Rahul Vijay
 * created 29th July 2019
 * desc : represent static methods like add, multiply polynomial
 * The Class Poly.
 */
public class Poly {
	
	/** The result poly degree. */
	private static int resultPolyDegree = 0;
	
	/**
	 * The main method.
	 * desc : call all methods 
	 * @param args the arguments
	 */
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Program Start");
		PolyStructure[] polynomial1 = new PolyStructure[50];
		PolyStructure[] polynomial2 = new PolyStructure[50];
		int deg1 = sc.nextInt();
		int deg2 = sc.nextInt();
		inputPolynomial(polynomial1,deg1);
		inputPolynomial(polynomial2,deg2);
		PolyStructure[] addOfTwoPoly = null;
		PolyStructure[] prodOfTwoPoly = null;
		System.out.println(evaluate(polynomial1, sc.nextFloat()));
		if(polynomial1[0] != null && polynomial2[0] != null){
			addOfTwoPoly = addPoly(polynomial1, polynomial2, deg1, deg2);
			prodOfTwoPoly = multiplyPoly(polynomial1, polynomial2, deg1, deg2);
		}else if(polynomial1[0] == null){
			prodOfTwoPoly = polynomial2;
			addOfTwoPoly = polynomial2;
		}else if(polynomial2[0] == null) {
			prodOfTwoPoly = polynomial1;
			addOfTwoPoly = polynomial1;
		}
		print(addOfTwoPoly);
		print(prodOfTwoPoly);
	}
	
	/**
	 * Evaluate.
	 * desc : evaluate polynomial on the basis of given float value
	 * @param polynomial1 the polynomial 1
	 * @param nextInt the next int
	 * @return the int
	 */
	private static float evaluate(PolyStructure[] polynomial1, float nextInt) {
		float eval = 0;
		for(int i = 0 ; i < polynomial1.length ; i++){
			if(polynomial1[i] == null) break;
			
			eval += polynomial1[i].getCoefficient() * Math.pow(nextInt, polynomial1[i].getExp());
		}
		return eval;
	}

	/**
	 * Multiply poly.
	 * desc : multiply two polynomials
	 * @param polynomial1 the polynomial 1
	 * @param polynomial2 the polynomial 2
	 * @param deg1 the deg 1
	 * @param deg2 the deg 2
	 * @return the poly structure[]
	 */
	private static PolyStructure[] multiplyPoly(PolyStructure[] polynomial1,
			PolyStructure[] polynomial2, int deg1, int deg2) {
		int i = 0; 
		int j = 0;
		int k = 0;
		resultPolyDegree = 0;
		PolyStructure[] prodOfTwoPoly = new PolyStructure[100];
		while(polynomial1[i] != null){
			j = 0;
			while(polynomial2[j] != null){
				//prodOfTwoPoly[k++]  = new PolyStructure(polynomial1[i].getCoefficient() * polynomial2[j].getCoefficient(), polynomial1[i].getExp()+polynomial2[j].getExp());
				if(prodOfTwoPoly[polynomial1[i].getExp() + polynomial2[j].getExp()] == null){
					prodOfTwoPoly[polynomial1[i].getExp() + polynomial2[j].getExp()]  = new PolyStructure(polynomial1[i].getCoefficient() * polynomial2[j].getCoefficient(), polynomial1[i].getExp()+polynomial2[j].getExp());
					resultPolyDegree++;
				}else{
					prodOfTwoPoly[polynomial1[i].getExp() + polynomial2[j].getExp()].setCoefficient(prodOfTwoPoly[polynomial1[i].getExp() + polynomial2[j].getExp()].getCoefficient() + polynomial1[i].getCoefficient() * polynomial2[j].getCoefficient());
				}
				j++;
			}
			i++;
		}
		return prodOfTwoPoly;
	}

	/**
	 * Prints the polynomial
	 *
	 * @param resultingPolynomial the resulting polynomial
	 */
	private static void print(PolyStructure[] resultingPolynomial) {
		System.out.print("Expression = "+resultingPolynomial[0].getCoefficient() + "x^" + resultingPolynomial[0].getExp());
		for(int i = 1 ; i < resultPolyDegree ; i++){
			System.out.print(" + "+resultingPolynomial[i].getCoefficient()+"x^"+resultingPolynomial[i].getExp());
		}
	}

	/**
	 * Input polynomial.
	 *
	 * @param polynomial the polynomial
	 * @param deg the deg
	 */
	private static void inputPolynomial(PolyStructure[] polynomial, int deg) {
		Scanner sc = new Scanner(System.in);
		int k = 0;
		for(int i = 0 ; i <= deg ; i++){
			int coeff = sc.nextInt();
			if(coeff != 0){
				polynomial[k] = new PolyStructure(coeff, i);
				k++;
			}
		}
	}

	/**
	 * Adds the poly.
	 * desc : add two polynomial
	 * @param polynomial1 the polynomial 1
	 * @param polynomial2 the polynomial 2
	 * @param deg1 the deg 1
	 * @param deg2 the deg 2
	 * @return the poly structure[]
	 */
	private static PolyStructure[] addPoly(PolyStructure[] polynomial1,
			PolyStructure[] polynomial2, int deg1, int deg2) {
		PolyStructure[] resultingPolynomail = new PolyStructure[50];
		resultPolyDegree = 0;
		int k = 0 ;
		int ptr1 = 0;
		int ptr2 = 0;
		if(deg1 > deg2){
			boolean flag = false;
			for(int i = 0 ; i <= deg2 ; i++){
				flag = false;
				if(polynomial1[ptr1].getExp() == i && polynomial2[ptr2].getExp() == i){
					resultingPolynomail[ptr1] = new PolyStructure(polynomial1[ptr1].getCoefficient() + polynomial2[ptr2].getCoefficient(), polynomial1[ptr1].getExp());
					ptr1++; ptr2++;
					flag = true;
				}else if(polynomial1[ptr1].getExp() == i){
					resultingPolynomail[k] = new PolyStructure(polynomial1[ptr1].getCoefficient(), polynomial1[ptr1].getExp());
					ptr1++;
					flag = true;
				}else if(polynomial2[ptr2].getExp() == i){
					resultingPolynomail[k] = new PolyStructure(polynomial2[ptr2].getCoefficient(), polynomial2[ptr2].getExp());
					ptr2++;
					flag = true;
				}
				
				if(flag == true){
					k++;
					resultPolyDegree++;
				}
			}
			for(int i = deg2 + 1 ; i <= deg1 ; i++){
				if(polynomial1[ptr1].getExp() == i){
					resultingPolynomail[k] = new PolyStructure(polynomial1[ptr1].getCoefficient(), polynomial1[ptr1].getExp());
					resultPolyDegree++;
					k++; ptr1++;
				}
			}
		}else{
			boolean flag = false;
			for(int i = 0 ; i <= deg1 ; i++){
				flag = false;
				if(polynomial1[ptr1].getExp() == i && polynomial2[ptr2].getExp() == i){
					resultingPolynomail[ptr1] = new PolyStructure(polynomial1[ptr1].getCoefficient() + polynomial2[ptr2].getCoefficient(), polynomial1[ptr1].getExp());
					ptr1++; ptr2++;
					flag = true;
				}else if(polynomial1[ptr1].getExp() == i){
					resultingPolynomail[k] = new PolyStructure(polynomial1[ptr1].getCoefficient(), polynomial1[ptr1].getExp());
					ptr1++;
					flag = true;
				}else if(polynomial2[ptr2].getExp() == i){
					resultingPolynomail[k] = new PolyStructure(polynomial2[ptr2].getCoefficient(), polynomial2[ptr2].getExp());
					ptr2++;
					flag = true;
				}
				
				if(flag == true){
					k++;
					resultPolyDegree++;
				}
			}
			for(int i = deg1 + 1 ; i <= deg2 ; i++){
				if(polynomial2[ptr2].getExp() == i){
					resultingPolynomail[k] = new PolyStructure(polynomial2[ptr2].getCoefficient(), polynomial2[ptr2].getExp());
					resultPolyDegree++;
					k++; ptr2++;
				}
			}
		}
		return resultingPolynomail;
	}

}
