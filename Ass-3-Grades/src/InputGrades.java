import java.util.ArrayList;
import java.util.Scanner;


// TODO: Auto-generated Javadoc
/**
 * The Class InputGrades.
 */
public class InputGrades {
	
	/**
	 * User input grades.
	 *
	 * @param gradesList the grades list
	 */
	public void userInputGrades(ArrayList<Integer> gradesList){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of Students");
		int numOfStudents = sc.nextInt();
		for(int i=0 ;i < numOfStudents; i++){
			System.out.println("Enter grade for student"+(i+1));
			gradesList.add(sc.nextInt());
		}
	}
}
