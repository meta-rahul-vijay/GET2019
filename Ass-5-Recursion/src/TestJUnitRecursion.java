import static org.junit.Assert.*;
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

// TODO: Auto-generated Javadoc
/**
 * author : Rahul Vijay
 * created : 23/07/2019 
 * The Class TestJUnitRecursion.
 */
public class TestJUnitRecursion {
	
	/**
	 * Test recursion problems.
	 */
	@Test
	public void testRecursionProblems(){
		System.out.println("Recursion");
		
		int hcf = Recursion.gcd(3, 5);
		assertThat(hcf, is(1));
		assertThat(3*5/hcf , is(15));
		System.out.println("hcf = 1");
		System.out.println("lcm = 15");
		
		
		int arr[] = new int[]{3,7,9,29,40};
		Search search = new Search();
		
		assertThat(search.linearSearch(arr, arr.length, 29), is(3));
		System.out.println("target is at position = 3");
		assertThat(search.linearSearch(arr, arr.length, 7), is(1));
		System.out.println("target is at position = 1");
		
		int size = 4;
		int nQueenArr[][] = new int[size][];
		for(int i=0 ; i<size ; i++){
			nQueenArr[i] = new int[size];
		}
		for(int i=0; i<size ; i++){
			Arrays.fill(nQueenArr[i], 0);
		}
		assertThat(Recursion.solveNQueen(nQueenArr, 0), is(true));
		System.out.println("NQueen Array: ");
		for(int i=0; i<nQueenArr.length ;i++){
			System.out.println(Arrays.toString(nQueenArr[i]));
		}
	}
}
