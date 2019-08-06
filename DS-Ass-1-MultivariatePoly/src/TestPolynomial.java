import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.*;


public class TestPolynomial{
	ArrayList<PolynomialTerm> polynomialTermList = new ArrayList<PolynomialTerm>();
	@Before  
	public void setUp() throws Exception {  
		System.out.println("Multivariate Polynomial");
		System.out.println("Enter variables");
		Variable var1 = new Variable('x', 2);
		Variable var2 = new Variable('y', 1);
		Variable var3 = new Variable('z', 3);
		ArrayList<Variable> variableList = new ArrayList<Variable>();
		variableList.add(var1);
		variableList.add(var2);
		variableList.add(var3);
		PolynomialTerm polynomialTerm = new PolynomialTerm(2, variableList);
		polynomialTermList.add(polynomialTerm);
		
		ArrayList<Variable> variableList1 = new ArrayList<Variable>();
		variableList1.add(var2);
		variableList1.add(var3);
		PolynomialTerm polynomialTerm1 = new PolynomialTerm(3, variableList1);
		polynomialTermList.add(polynomialTerm1);
	}
	
	@Test(expected = AssertionError.class)
	public void getDegree(){
		MultivariatePolynomial multivariatePolynomial = new MultivariatePolynomial(null);
		System.out.println("Degree = "+multivariatePolynomial.getDegree());  
		multivariatePolynomial.print();
		System.out.println("");
		System.out.println("Polynomial = "+multivariatePolynomial.toString());
		String expected = "2x^2y^1z^3 + 3y^1z^3";
		assertThat(multivariatePolynomial.getDegree(), is(6));
		assertThat(multivariatePolynomial.toString(), is(expected));
	}
}