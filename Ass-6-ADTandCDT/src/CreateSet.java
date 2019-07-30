import java.util.Arrays;


public class CreateSet {
	
	private int capacity;
	private int size;
	private int set[];
	
	
	public CreateSet() {
		capacity = 1000;
		size = 0;
		set = new int[capacity];
	}
	
	public void add(int element){
		if(size == capacity){
			return;
		}
		for(int i = 0 ; i < size ; i++){
			if(set[i] == element){
				return;
			}
		}
		set[size++] = element;
	}

	public boolean isMember(int member) {
		for(int i = 0 ; i < capacity ; i++){
			if(set[i] == member){
				return true;
			}
		}
		return false;
	}


	public int size() {
		return size;
	}


	public boolean isSubSet(int[] subset) {
		for(int i = 0 ; i < subset.length ; i++){
			for(int j = 0 ; j < set.length ; j++){
				if(subset[i] == set[j]){
					break;
				}
				if(j == set.length - 1){
					return false;
				}
			}
		}
		return true;
	}

	public int[] getComplement(int array[]) {
		Arrays.sort(array); 
		int[] complement = new int[1000 - array.length + 1];
		int j = 0;
		int k = 0;
		for(int i = 0 ; i < 1000 ; i++){
			if(k < array.length && array[k] == i+1){
				k++;				
			}else if(k < array.length && array[k] != i+1){
				complement[j++] = i+1;
			}
			if(k == array.length){
				complement[j++] = i+1;
			}	
		}
		return complement;
	}

	public int[] union(int[] setA, int[] setB) {
		Arrays.sort(setA);
		Arrays.sort(setB);
		int i = 0;
		int j = 0;
		int k = 0;
		int count = 0;
		while(i < setA.length && j < setB.length){
			if(setA[i] == setB[j]){
				i++;
				j++;
				count++;
			}else if(setA[i] > setB[j]){
				j++;
			}else{
				i++;
			}
		}
		i = 0;
		j = 0;
		int setC[] = new int[setA.length + setB.length - count];
		
		while(i < setA.length && j < setB.length){
			if(setA[i] == setB[j]){
				setC[k] = setA[i];
				i++;
				j++;
			}else if(setA[i] > setB[j]){
				setC[k] = setB[j];
				j++;
			}else{
				setC[k] = setA[i];
				i++;
			}
			k++;
		}
		while(j < setB.length){
			setC[k] = setB[j];
			k++;
			j++;
		}
		while(i < setA.length){
			setC[k] = setA[i];
			k++;
			i++;
		}
		return setC;
	}
}
