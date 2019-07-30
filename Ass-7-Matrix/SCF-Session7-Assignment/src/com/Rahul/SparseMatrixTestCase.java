package com.Rahul;


import static org.junit.Assert.*;
import org.junit.Test;
/**
 * Test cases for Sparse Matrix
 * @author Rahul Vijay
 * created 30 July 2019
 *
 */
public class SparseMatrixTestCase {
	
	/**
	 * This test case is not part of problem.
	 * It produces compact sparse matrix internally and .getMatrix() returns the normal matrix
	 */
	@Test
	public void SparseMatrixTest1 () {
		
		int [][] matrix1 = {{0,0,1}, {0,3,0}, {1,0,0}};
		int [][] result = {{0,2,1}, {1,1,3}, {2,0,1}};
		
		SparseMatrix sp1 = new SparseMatrix(matrix1);
		assertArrayEquals(result,sp1.getMatrix()); //checks whether compact matrix is correct or not
				
	}

	/**
	 * adds 2 sparse matrices and checks if expected addition is correct
	 */
	@Test
	public void SparseMatrixTest2 () {
		
		int [][] matrix1 = {{0,0,1}, {0,3,0}, {1,0,0}};
		int [][] matrix2 = {{1,0,0}, {0,0,0}, {0,0,1}};
		int [][] matrix3 = {{1,0,1}, {0,3,0}, {1,0,1}};
		
		SparseMatrix sp1 = new SparseMatrix(matrix1);
		SparseMatrix sp2 = new SparseMatrix(matrix2);
		
		assertArrayEquals(matrix3,sp1.addMatrix(sp2));		//adding two matrices
	}
	
	/**
	 * The test case verifies if the sparse matrix supplies is symmetrical or not
	 */
	@Test
	public void SparseMatrixTest3 () {
		
		int [][] matrix1 = {{0,0,1}, {2,0,3}, {0,1,0}};		
		SparseMatrix sp1 = new SparseMatrix(matrix1);
		
		assertTrue(sp1.isSymmetrical());			//checks whether matrix is symmetrical	
	}
	
	/**
	 * gets the transpose of the sparse matrix 
	 */
	@Test
	public void SparseMatrixTest4 () {
		
		int [][] matrix1 = {{0,10,0,12}, {0,0,0,0}, {0,0,5,0}, {15,12,0,0}};
		int [][] matrix2 = {{0,0,0,15}, {10,0,0,12}, {0,0,5,0}, {12,0,0,0}};
		
		SparseMatrix sp1 = new SparseMatrix(matrix1);
		
		assertArrayEquals(matrix2,sp1.getTranspose());			//checks the transpose of the matrix	
	}
	
	/**
	 * multiplies two sparse matrices
	 */
	@Test
	public void SparseMatrixTest5 () {
		
		int [][] matrix1 = {{0,1,}, {2,0}};
		int [][] matrix2 = {{1,0,3}, {2,0,0}};
		
		int [][] result = {{2,0,0}, {2,0,6}};
		
		SparseMatrix sp1 = new SparseMatrix(matrix1);
		SparseMatrix sp2 = new SparseMatrix(matrix2);
		
		assertArrayEquals(result,sp1.multiplyMatrix(sp2));	 //checks whether multiplication is correct					
	}
}
