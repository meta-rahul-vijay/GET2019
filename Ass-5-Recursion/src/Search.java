
/**
 * The Class Search.
 * author : Rahul Vijay
 * created : 23/07/2019
 * description  : contains two methods linear search and binary search
 */
public class Search {
	
	/**
	 * Linear search.
	 * description : perform search through out the length of array
	 * @param  arr
	 * @param int len
	 * @param int target
	 * @return the int
	 */
	public int linearSearch(int arr[], int len, int target){
		if( len <= 0){
			return -1;
		}
		if(arr[len-1] == target){
			return len-1;
		}
		return linearSearch(arr, len-1, target);
	}
	
	/**
	 * Binary search.
	 * description : perform binary search in array perform only in sorted array
	 * @param arr
	 * @param int start
	 * @param int end
	 * @param int target
	 * @return  int
	 */
	public int binarySearch(int arr[], int start, int end, int target){
		if(start > end){
			return -1;
		}
		int mid = (start + end)/2;
		if(target == arr[mid]){
			return mid;
		}
		else if(target > arr[mid]){
			return binarySearch(arr, mid+1, end, target);
		}
		else{
			return binarySearch(arr, start, mid-1, target);
		}
	}

}
