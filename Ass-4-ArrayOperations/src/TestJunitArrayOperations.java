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
 * created : 19 July 2019
 * description : Check Positive and negative Test cases of all impliment functions 
 * The Class TestJunitArrayOperations.
 */
public class TestJunitArrayOperations {
	
	/**
	 * The Class ParametersTestJunitNumberOfClumps.
	 */
	@RunWith(Parameterized.class)
	public static class ParametersTestJunitNumberOfClumps{
		
		/**
		 * Sets the up before class.
		 *
		 * @throws Exception the exception
		 */
		@BeforeClass
		public static void setUpBeforeClass() throws Exception {  
			System.out.println("before class");  
	    }
		
		/**
		 * Sets the up.
		 *
		 * @throws Exception the exception
		 */
		@Before  
		public void setUp() throws Exception {  
			System.out.println("before");  
		} 
		
		/**
		 * Data.
		 *
		 * @return the collection
		 */
		@Parameters
	    public static Collection<Object[]> data() {
	        return Arrays.asList(new Object[][] {
	                 {new int[]{1, 2, 2, 3, 4, 4} , 2 }, {new int[]{1, 1, 2, 1, 1}, 2 }, {new int[]{1, 1, 1, 1, 1}, 2 }, {new int[]{} , 0}
	                 //The first item in the array is the input, and second is the expected outcome.
	           });
	    }

	    /** The input. */
    	private int[] input;
	    
    	/** The expected. */
    	private int expected;
	    
    	/** The test case number. */
    	static int testCaseNumber = 0;
	    
	    /**
    	 * Instantiates a new parameters test junit number of clumps.
    	 * This constructor must be provided for the parameterized tests to work.
    	 * @param input the input
    	 * @param expected the expected
    	 */
	    public ParametersTestJunitNumberOfClumps(int[] input, int expected) {
	        this.input = input;
	        this.expected = expected;
	    }
	    
	    /**
    	 * Find number of clumps.
    	 */
    	@Test
	    public void findNumberOfClumps() {
	    	testCaseNumber++;
	        assertThat(ArrOperation.findNumberOfClumps(input), is(expected));
	        System.out.println("Number Of Clumps for test case "+ testCaseNumber + " : "+expected);
	    }
	    
    	/**
    	 * Tear down.
    	 *
    	 * @throws Exception the exception
    	 */
    	@After  
	    public void tearDown() throws Exception {  
	        System.out.println("after");  
	    }  
	  
	    /**
    	 * Tear down after class.
    	 *
    	 * @throws Exception the exception
    	 */
    	@AfterClass  
	    public static void tearDownAfterClass() throws Exception {  
	        System.out.println("after class");  
	    }  
	}
	
	
	/**
	 * The Class ParametersTestJunitSplitIndex.
	 */
	@RunWith(Parameterized.class)
	public static class ParametersTestJunitSplitIndex {
		
		/**
		 * Sets the up before class.
		 *
		 * @throws Exception the exception
		 */
		@BeforeClass
		public static void setUpBeforeClass() throws Exception {  
			System.out.println("before class");  
	    }
		
		/**
		 * Sets the up.
		 *
		 * @throws Exception the exception
		 */
		@Before  
		public void setUp() throws Exception {  
			System.out.println("before");  
		}
		
		/**
		 * Data.
		 *
		 * @return the collection
		 */
		@Parameters
	    public static Collection<Object[]> data() {
	        return Arrays.asList(new Object[][] {
	                 {new int[]{1, 1, 1, 2, 1} , 3 }, {new int[]{2, 1, 1, 2, 1}, -1}, {new int[]{10, 10}, 1 }, {new int[]{} , 0}
	                 //The first item in the array is the input, and second is the expected outcome.
	           });
	    }

	    /** The input. */
    	private int[] input;
	    
    	/** The expected. */
    	private int expected;
	    
    	/** The test case number. */
    	static int testCaseNumber = 0; 
	    
	    /**
    	 * Instantiates a new parameters test junit split index.
    	 *
    	 * @param input the input
    	 * @param expected the expected
    	 */
    	//This constructor must be provided for the parameterized tests to work.
	    public ParametersTestJunitSplitIndex(int[] input, int expected) {
	        this.input = input;
	        this.expected = expected;
	    }
	    
	    /**
    	 * Find split index.
    	 * Use assertion for checking that actual and expected are equal or not
    	 */
    	@Test
	    public void findSplitIndex() {
	    	testCaseNumber++;
	        assertThat(ArrOperation.findSplitIndex(input), is(expected));
	        System.out.println("Split Index for test case "+ testCaseNumber + " : " + expected);
	    }
	    
    	/**
    	 * Tear down.
    	 *
    	 * @throws Exception the exception
    	 */
    	@After  
	    public void tearDown() throws Exception {  
	        System.out.println("after");  
	    }  
	  
	    /**
    	 * Tear down after class.
    	 *
    	 * @throws Exception the exception
    	 */
    	@AfterClass  
	    public static void tearDownAfterClass() throws Exception {  
	        System.out.println("after class");  
	    }
	}
	
	
	/**
	 * The Class ParametersTestJunitLargestMirrorSection.
	 */
	@RunWith(Parameterized.class)
	public static class ParametersTestJunitLargestMirrorSection {
		
		/**
		 * Sets the up before class.
		 *
		 * @throws Exception the exception
		 */
		@BeforeClass
		public static void setUpBeforeClass() throws Exception {  
			System.out.println("before class");  
	    }
		
		/**
		 * Sets the up.
		 *
		 * @throws Exception the exception
		 */
		@Before  
		public void setUp() throws Exception {  
			System.out.println("before");  
		}
		
		/**
		 * Data.
		 *
		 * @return the collection
		 */
		@Parameters
	    public static Collection<Object[]> data() {
	        return Arrays.asList(new Object[][] {
	        		{new int[]{1, 2, 3, 8, 9, 3, 2, 1}, 3}, {new int[]{7, 1, 4, 9, 7, 4, 1}, 2}, {new int[]{1, 2, 1, 4}, 3}, {new int[]{1, 4, 5, 3, 5, 4, 1}, new int[]{1, 4, 5, 1, 1, 4, 5}}, {new int[]{}, 0}
	                 //The first item in the array is the input, and second is the expected outcome.
	           });
	    }

	    /** The input. */
    	private int[] input;
	    
    	/** The expected. */
    	private int expected;
	    
    	/** The test case number. */
    	static int testCaseNumber = 0;
	    
	    /**
    	 * Instantiates a new parameters test junit largest mirror section.
    	 *
    	 * @param input the input
    	 * @param expected the expected
    	 */
    	//This constructor must be provided for the parameterized tests to work.
	    public ParametersTestJunitLargestMirrorSection(int[] input, int expected) {
	        this.input = input;
	        this.expected = expected;
	    }
	    
	    /**
    	 * Largest mirror section.
    	 */
    	@Test
	    public void largestMirrorSection() {
	    	testCaseNumber++;
	        assertThat(ArrOperation.largestMirrorSection(input), is(expected));
	        System.out.println("Largest Mirror Section for test case "+ testCaseNumber + " : " + expected);
	    }
	    
    	/**
    	 * Tear down.
    	 *
    	 * @throws Exception the exception
    	 */
    	@After  
	    public void tearDown() throws Exception {  
	        System.out.println("after");  
	    }  
	  
	    /**
    	 * Tear down after class.
    	 *
    	 * @throws Exception the exception
    	 */
    	@AfterClass  
	    public static void tearDownAfterClass() throws Exception {  
	        System.out.println("after class");  
	    }
	}
	
	
	/**
	 * The Class ParametersTestJunitFixxyProblem.
	 */
	@RunWith(Parameterized.class)
	public static class ParametersTestJunitFixxyProblem {
		
		/**
		 * Sets the up before class.
		 *
		 * @throws Exception the exception
		 */
		@BeforeClass
		public static void setUpBeforeClass() throws Exception {  
			System.out.println("before class");  
	    }
		
		/**
		 * Sets the up.
		 *
		 * @throws Exception the exception
		 */
		@Before  
		public void setUp() throws Exception {  
			System.out.println("before");  
		}
		
		/**
		 * Data.
		 *
		 * @return the collection
		 */
		@Parameters
	    public static Collection<Object[]> data() {
	        return Arrays.asList(new Object[][] {
	        		{new int[]{5, 4, 9, 4, 9, 5}, new int[]{9, 4, 5, 4, 5, 9}}, {new int[]{1, 4, 1, 5}, new int[]{1, 4, 5, 1}}, {new int[]{1, 4, 1, 5, 5, 4, 1}, new int[]{1, 4, 5, 1, 1, 4, 5}}, {new int[]{1, 4, 5, 3, 5, 4, 1}, 7}, {new int[]{}, new int[]{}}
	                 //The first item in the array is the input, and second is the expected outcome.
	           });
	    }

	    /** The input. */
    	private int[] input;
	    
    	/** The expected. */
    	private int[] expected;
	    
    	/** The test case number. */
    	static int testCaseNumber = 0;
	    
	    /**
    	 * Instantiates a new parameters test junit fixxy problem.
    	 *
    	 * @param input the input
    	 * @param expected the expected
    	 */
    	//This constructor must be provided for the parameterized tests to work.
	    public ParametersTestJunitFixxyProblem(int[] input, int[] expected) {
	        this.input = input;
	        this.expected = expected;
	    }
	    
	    /**
    	 * Solve fixxy problem.
    	 */
    	@Test
	    public void solveFixxyProblem() {
	    	testCaseNumber++;
	        assertThat(ArrOperation.solveFixxyProblem(input), is(expected));
	        System.out.println("Fixxy Problem for test case "+ testCaseNumber + " : "+Arrays.toString(expected));
	    }
	    
    	/**
    	 * Tear down.
    	 *
    	 * @throws Exception the exception
    	 */
    	@After  
	    public void tearDown() throws Exception {  
	        System.out.println("after");  
	    }  
	  
	    /**
    	 * Tear down after class.
    	 *
    	 * @throws Exception the exception
    	 */
    	@AfterClass  
	    public static void tearDownAfterClass() throws Exception {  
	        System.out.println("after class");  
	    }
	}
	
	/*@BeforeClass
	public static void setUpBeforeClass() throws Exception {  
		System.out.println("before class");  
    }
	
	@Before  
	public void setUp() throws Exception {  
		System.out.println("before");  
	} */
	
	/*@Test  
    public void largestMirrorSection(){  
        System.out.println("Largest Mirror Section");  
        int largest = ArrOperation.largestMirrorSection(new int[]{1, 2, 3, 8, 9, 3, 2, 1});
        assertEquals(3,largest);
        assertEquals(2,ArrOperation.largestMirrorSection(new int[]{7, 1, 4, 9, 7, 4, 1}));
        //System.out.println("LMS = "+"2");
        assertEquals(3,ArrOperation.largestMirrorSection(new int[]{1, 2, 1, 4}));
        assertEquals(7,ArrOperation.largestMirrorSection(new int[]{1, 4, 5, 3, 5, 4, 1}));
        assertThat(ArrOperation.largestMirrorSection(new int[]{1, 2, 3, 8, 9, 3, 2, 1}), is(3));
        //assertEquals(3,ArrOperation.largestMirrorSection(new int[]{}));// Throw assertion error in case array is empty
    } 
	*/
	/*@Test
	public void findSplitIndex(){
		System.out.println("Split Index");
		assertThat(ArrOperation.findSplitIndex(new int[]{1, 1, 1, 2, 1}), is(3));
		assertThat(ArrOperation.findSplitIndex(new int[]{1, 1, 1, 2, 1}), is(3));
		assertThat(ArrOperation.findSplitIndex(new int[]{10, 10}), is(3));
		System.out.println("="+ArrOperation.findSplitIndex(new int[]{1, 1, 1, 2, 1}));
		System.out.println("="+ArrOperation.findSplitIndex(new int[]{1, 1, 1, 2, 1}));
	}

	@Test
	public void solveFixxyProblem(){
		System.out.println("Solve Fixxy Problem");
		int expected[] = new int[]{9, 4, 5, 4, 5, 9};//ArrOperation.solveFixxyProblem(new int[]{5, 4, 9, 4, 9, 5});
		assertArrayEquals(ArrOperation.solveFixxyProblem(new int[]{5, 4, 9, 4, 9, 5}), expected);
	}*/
	
	/*@After  
    public void tearDown() throws Exception {  
        System.out.println("after");  
    }  
  
    @AfterClass  
    public static void tearDownAfterClass() throws Exception {  
        System.out.println("after class");  
    }  */
}
