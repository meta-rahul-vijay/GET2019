package com.Rahul;

/**
 * The class contains methods to operate on sparse matrices, transpose, addition
 * ,multiplication, checking Symmetric matrix. Time Complexity is O(N^2)
 * @author Shobhit Bhatnagar
 *
 */
public class SparseMatrix {
	
	private int [][] data;
	private int row, col;
	
	public SparseMatrix(int[][] array) {
	    //store dimension of array
		row = array.length;
		col = array[0].length;
		//count non-zero element in array
		int size = countNonZero(array);
		this.data = new int[size][3];  //column length is fixed
		int rowCount = 0;                //for storing elements in sparse matrix
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				if (array[i][j] != 0){
				    //store non-zero elements in sparse matrix
					data[rowCount][0] = i;
					data[rowCount][1] = j;
					data[rowCount][2] = array[i][j];
					rowCount++;
				}
			}
		}
	}
	
	
	
	/**
	 * Send Us The Value of Non-zero value in A matrix
	 * @param matrix	The Integer 2-D Array/Matrix in which we have to find 
	 * the non zero element count.Time complexity is O(N^2)
	 * @return			The Count of non Zero element in matrix.
	 */
	public static int countNonZero(int matrix[][]) {
	    //count non-zero elements
		int count = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] != 0)
					count++;
			}
		}
		return count;
	}
	
	
	/**
	 * 
	 * @return	An 2D Integer Array, Sparse Matrix in which matrix[0] = row, 
	 * matrix[1] = column, matrix[2] = non zero value at these index 
	 */
	public int[][] getMatrix() {
		return data;
	}
	/**
	 * 
	 * @return An Integer value, Which is Equal to Row of given Matrix.
	 */
	public int getRowSize() {
		return row;
	}
	/**
	 * 
	 * @return An Integer value, Which is Equal to Column of given Matrix.
	 */
	public int getColSize() {
		return col;
	}
	
	
	/**
	 * 
	 * @param sparseMatrix	An Sparse matrix
	 * @param row	Number of rows in Matrix from whom it is converted.
	 * @param col	Number of column in Matrix from whom it is converted.
	 *	Time complexity is O(N)
	 * @return		An 2D Array which is the matrix representation 
	 * of the compact Sparse matrix
	 */
	public int[][] convertInMatrix(int[][] sparseMatrix,int row,int col){
	    //convert sparse matrix to matrix
		int[][] result=new int[row][col];
		for(int index = 0; index < sparseMatrix.length; index++){
			result[sparseMatrix[index][0]][sparseMatrix[index][1]] = sparseMatrix[index][2];	
		}
		return result;
	}
	
	
	
	/**
	 * Gets us The Transpose of the given Sparse Matrix.
	 * @return	Return us an 2D Integer array which is transpose of the given Sparse Matrix.
	 */
	public int[][] getTranspose() {
	    //transpose of sparse matrix
		int[][] transMatrix = new int[data.length][3];
		for (int i = 0; i < data.length; i++) {
		    //interchange columns and rows of sparse matrix
			transMatrix[i][0] = data[i][1];
			transMatrix[i][1] = data[i][0];
			transMatrix[i][2] = data[i][2];
		}
		//convert in 2d matrix
		return convertInMatrix(transMatrix, col, row);
	}
	
	/**
	 * Time complexity is O(N)
	 * @return	Returns True If the given Sparse Matrix is Symmetrical else False.
	 */
	public boolean isSymmetrical() {
		
		int index1, index2;
		SparseMatrix sp = new SparseMatrix(getTranspose());
		int[][] transMatrix = sp.getMatrix();
		if (data.length == transMatrix.length) {
			for (index1 = 0; index1 < data.length; index1++) {
				for (index2 = 0; index2 < transMatrix.length; index2++) {
					if (data[index1][0] == transMatrix[index2][0] 
							&& data[index1][1] == transMatrix[index2][1] 
									&& data[index1][2] == transMatrix[index2][2]) {
						//check element of sparse matrix
					    break;
					}
				}
				if (index2 >= transMatrix.length)
					return false;
			}
			return true;
		}
		return false;
	}
	
	
	/**
	 * Time complexity is O(N^2)
	 * @param sp	Second Integer matrix to be added in the First Matrix 
	 * @return		An 2D Integer Array, The Sum of two compact Sparse Matrix. 
	 */
	public int[][] addMatrix(SparseMatrix sp) {
		//check addition condition of matrix
			if (row == sp.getRowSize() && col == sp.getColSize()) {
			    int[][] matrix2 = sp.getMatrix();
				int commonElements = commonElementCount(data, matrix2);
				//initialize result matrix
				int[][] result = new int[data.length + matrix2.length - commonElements][3];
				for (int i = 0; i < data.length; i++) {
					for (int j = 0; j < 3; j++)
					    //put one matrix in result matrix
						result[i][j] = data[i][j];
				}
				for (int index1 = 0; index1 < matrix2.length; index1++) {
					int index2;
					for (index2 = 0; index2 < data.length; index2++) {
						if (matrix2[index1][0] == result[index2][0] && matrix2[index1][1] == result[index2][1]) {
						    //add common element of matrix2 in result matrix
							result[index2][2] += matrix2[index1][2];
							break;
						}
					}
					if (index2 >= data.length) {
					    //add non common elements in result matrix
						result[data.length + index1][0] = matrix2[index1][0];
						result[data.length + index1][1] = matrix2[index1][1];
						result[data.length + index1][2] = matrix2[index1][2];
					}
				}
				return convertInMatrix(result, row, col);
	            }
		else
			throw new AssertionError("dimensions not equal");
	}
	
	
	/**
	 * Returns the number of common row and col of two Sparse Matrix. Time complexity is O(N^2)
	 * @param array1	First Sparse Matrix, An integer 2D array 
	 * @param array2	Second Sparse Matrix, An integer 2D array
	 * @return			Returns the number of common elements that is 
	 * having same row and column.
	 */
	private int commonElementCount(int[][] array1, int[][] array2) {
	    //count common elements in two array
		int count = 0;
		for (int index1 = 0; index1 < array1.length; index1++) {
			for (int index2 = 0; index2 < array2.length; index2++) {
				if (array1[index1][0] == array2[index2][0] && array1[index1][1] == array2[index2][1]) {
					count++;					
				}					
			}
		}
		//System.out.print(count);
		return count;
	}
	
	/**
	 *  Returns a 2D Array which is equal to Multiplication of two Sparse Matrix.
	 *  First matrix of the two matrix to be multiplied is known by this as due 
	 *  to the reference of first matrix the method is called. Time complexity is O(N^2)
	 * @param sp 	The Second Sparse matrix, Of the Two which we have to multiply.
	 * @return		Returns An 2D Integer Array, Which is Equal to Multiplication of two Sparse Matrix. 	
	 */
	public int[][] multiplyMatrix(SparseMatrix sp){
		//check condition of multiplication of matrix
		if(col == sp.getRowSize()){
			int[][] result = new int[row][sp.getColSize()];
			int[][] matrix2 = new SparseMatrix(sp.getTranspose()).getMatrix();
			for(int index1 = 0;index1<data.length;index1++){
				for(int index2 =0;index2<matrix2.length;index2++){
					if(data[index1][1]==matrix2[index2][1] )
					    //multiply elements of matrix
						result[data[index1][0]][matrix2[index2][0]]+=data[index1][2]*matrix2[index2][2];
				}
			}
			return result;
		}else
			throw new AssertionError("multiplication condition is not satisfied");
		
	}
}
