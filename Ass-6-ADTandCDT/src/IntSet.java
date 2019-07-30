import java.util.Arrays;
import java.util.Scanner;


public class IntSet {
	//private static int[] setArray = new int[]{1,2,5,7,89};
	public static void main(String args[]){
		System.out.println("Program for implementing set using array");
		CreateSet setArray = new CreateSet();
		Scanner sc = new Scanner(System.in);
		setArray.add(1);
		setArray.add(7);
		setArray.add(50);
		setArray.add(35);
		setArray.add(2);
		setArray.add(9);
		setArray.add(5);
		setArray.add(89);
		setArray.add(90);
		setArray.add(5);
		System.out.println(setArray.isMember(sc.nextInt()));
		System.out.println(setArray.size());
		int[] subset = new int[]{1,35,2,89};
		System.out.println(setArray.isSubSet(subset));
		System.out.println(Arrays.toString(setArray.getComplement(subset)));
		int setA[] = new int[]{3,7,2,9,4,56,74,23};
		int setB[] = new int[]{9,4,56,7,2,100};
		System.out.println(Arrays.toString(setArray.union(setA, setB)));
	}
}
