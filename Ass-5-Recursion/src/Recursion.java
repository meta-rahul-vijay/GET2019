import java.util.Arrays;

/**
 * The Class Recursion.
 * author : Rahul Vijay
 * created : 23/07/2019
 * description : contains two static methods gcd and solveNqueen
 */
public class Recursion {

	/**
	 * Gcd.
	 * description : find greatest common divisor of two numbers 
	 * @param int a
	 * @param int b 
	 * @return int
	 */
	public static int gcd(int a, int b){
		if(a == 0){
			return b;
		}
		return gcd(b%a , a);	
	}
	
	/**
	 * Solve N queen.
	 * description : if possible two put nQueen on chessboard with no interuption return true else false
	 * @param nQueenArr the n queen arr
	 * @param col the col
	 * @return true, if successful
	 */
	public static boolean solveNQueen(int[][] nQueenArr, int col){
		
		
		if(col >= nQueenArr.length){
			return true;
		}
		
		for(int i=0 ; i<nQueenArr.length ; i++){
			if(isSafe(nQueenArr, i, col)){
				nQueenArr[i][col] = 1;
			
				if(solveNQueen(nQueenArr, col+1) == true)
					return true;
			
				nQueenArr[i][col] = 0;
			}
		}
		
		return false;
		
	}

	/**
	 * Checks if is safe to put queen on chess board.
	 *
	 * @param nQueenArr the n queen arr
	 * @param int row
	 * @param int col
	 * @return true, if is safe
	 */
	public static boolean isSafe(int nQueenArr[][], int row, int col) {
		
		
		int i, j; 
		  
        // check on left side
        for (i = 0; i < col; i++) 
            if (nQueenArr[row][i] == 1) 
                return false; 
  
        //Check upper diagonal on left side
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) 
            if (nQueenArr[i][j] == 1) 
                return false; 
  
        //Check lower diagonal on left side
        for (i = row, j = col; j >= 0 && i < nQueenArr.length; i++, j--) 
            if (nQueenArr[i][j] == 1) 
                return false; 
  
        return true; 
	}
}
