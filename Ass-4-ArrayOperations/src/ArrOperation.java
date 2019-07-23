import java.util.ArrayList;
import java.util.Scanner;


// TODO: Auto-generated Javadoc
/**
 * author : Rahul Vijay
 * created : 19 July 2019
 * description : 4 functions  
 * The Class ArrOperation.
 */
public class ArrOperation {
	
	/*public static void main(String[] args) {
	    int[] arr = new int[]{1, 4, 1, 5, 5, 4, 4};
	    System.out.println(largestMirrorSection(arr));   
	    System.out.println(findNumberOfClumps(arr)); 
	    System.out.println(findSplitIndex(arr));
	    int resultingArray[] = solveFixxyProblem(arr);
	    if(resultingArray == null){
	    	System.out.println("Error in input array : Exit");
	    	return;
	    }
	    System.out.println("Resulting Array : ");
	    for(int i=0 ; i<resultingArray.length ; i++){
	    	System.out.print(resultingArray[i] + " ");
	    }
	}*/
	
	/**
	 * Largest mirror section returns the largest mirror size in the complete array.
	 *
	 * @param integer array
	 * @return integer
	 */
	public static int largestMirrorSection(int arr[]){
		int size = arr.length;
		if(size == 0){
			System.out.println("Empty array exception caught in largest Mirror Section");
			throw new AssertionError();
		}
        int lcs[][] = new int[size + 1][size + 1]; 
        int result = 0;

        for (int i=0; i<=size; i++) 
        { 
            for (int j=0; j<=size; j++) 
            { 
                if (i == 0 || j == 0) 
                lcs[i][j] = 0; 
    
                else if (arr[i-1] == arr[size-j]) 
                { 
                    lcs[i][j] = lcs[i-1][j-1] + 1; 
                    result = Integer.max(result, lcs[i][j]); 
                } 
                else lcs[i][j] = 0; 
            } 
        }    
        return result;    
    }
	
	/**
	 * Find number of clumps return the number of clumps(consecutive numbers) which is greater than two.
	 *
	 * @param integer array
	 * @return integer
	 */
	public static int findNumberOfClumps(int arr[]){
		if(arr.length == 0){
			System.out.println("Empty array exception caught in number of clumps");
			throw new AssertionError();
		}
		int clumpLength = 1;
		int curr = 0;
		int next = 1;
		int numOfClumps = 0;
		while(next < arr.length){
			if(arr[curr] == arr[next]){
				clumpLength++;
				next++;
				if(clumpLength == 2){
					numOfClumps++;
				}
			}
			else{
				clumpLength = 1;
				curr = next;
				next++;
			}
		}
		return numOfClumps;
	}
	
	/**
	 * Find split index return the index from which sum of left side of index and sum of right side of index is equal
	 *
	 * @param integer array
	 * @return integer
	 */
	public static int findSplitIndex(int arr[]){
		int arrLength = arr.length;
		if(arrLength == 0){
			System.out.println("Empty array exception caught in split index");
			throw new AssertionError();
		}
		int start = 0;
		int end =arrLength -1;
		int leftSum = arr[0];
		int rightSum = arr[end];
		while(start < end){
			if(leftSum == rightSum){
				start++;
				end--;
				if(start <= end){
					leftSum += arr[start];
					rightSum += arr[end];
				}
			}else if(leftSum < rightSum){
				start++;
				if(start <= end){
					leftSum += arr[start];
				}
			}
			else{
				end--;
				if(start <= end){
					rightSum += arr[end];
				}
			}
		}
		if(leftSum == rightSum && start!=end){
			return start;
		}
		return -1;
	}
	
	/**
	 * Solve fixxy problem return the array with x follows y if possible 
	 *
	 * @param integer array
	 * @return integer array
	 */
	public static int[] solveFixxyProblem(int arr[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter x and y");
		int x = sc.nextInt();
		int y = sc.nextInt();
		int length = arr.length;
		if(length == 0){
			System.out.println("Empty array exception caught in solve fixxy problem");
			throw new AssertionError();
		}
		else if(arr[length - 1] == x){
			System.out.println("exception caught in solve fixxy problem because "+ arr[length - 1] +"is at end");
			throw new AssertionError();
		}
		for(int i=0 ; i < length - 1 ; i++){
			if(arr[i] == arr[i+1] && arr[i] == x){
				System.out.println("exception caught in solve fixxy problem because two consecutive elements are same and equal to "+arr[i]);
				throw new AssertionError();
			}
		}
		ArrayList<Integer> indexOfX = new ArrayList<Integer>();
		ArrayList<Integer> indexOfY = new ArrayList<Integer>();
		for(int i=0 ; i<length ; i++){
			if(arr[i] == x){
				indexOfX.add(i);
			}
			else if(arr[i] == y){
				indexOfY.add(i);
			}
		}
		if(indexOfX.size() != indexOfY.size()){
			System.out.println("exception caught in solve fixxy problem because number of both elements are not equal");
			throw new AssertionError();
		}
		for(int i=0 ; i<indexOfX.size() ; i++){
			int temp = arr[indexOfX.get(i) + 1];
			arr[indexOfX.get(i) + 1] = arr[indexOfY.get(i)];
			arr[indexOfY.get(i)] = temp;
		}
		return arr;
	}
}
