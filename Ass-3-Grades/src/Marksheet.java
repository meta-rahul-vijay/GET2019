import java.text.DecimalFormat;
import java.util.ArrayList;


// TODO: Auto-generated Javadoc
/**
 * The Class Marksheet.
 */
public class Marksheet {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String args[]){
		InputGrades inputGrades = new InputGrades();
		ArrayList<Integer> gradesList = new ArrayList<Integer>();
		inputGrades.userInputGrades(gradesList);
		System.out.println("Äverage of all Grades = "+averageOfAllGrades(gradesList));
		System.out.println("Maximum of all Grades = "+maximumOfAllGrades(gradesList));
		System.out.println("Minimum of all Grades = "+minimumOfAllGrades(gradesList));
		System.out.println("Percentage of students passed = "+percentageOfStudentsPassed(gradesList));
	}

	/**
	 * Percentage of students passed.
	 *
	 * @param gradesList the grades list
	 * @return the string
	 */
	private static String percentageOfStudentsPassed(ArrayList<Integer> gradesList) {
		// TODO Auto-generated method stub
		float size = gradesList.size();
		float numOfPassedStud = 0;
		for(int i =0; i< size ; i++){
			if(gradesList.get(i) > 40){
				numOfPassedStud++;
			}
		}
		try{
			return convertToTwoDigitsAfterDecimal((numOfPassedStud/size)*100);
		}catch(Exception e){
			System.out.println("Exception caught in percentageOfStudentsPassed");
			return null;
		}
	}

	/**
	 * Minimum of all grades.
	 *
	 * @param gradesList the grades list
	 * @return the int
	 */
	private static int minimumOfAllGrades(ArrayList<Integer> gradesList) {
		// TODO Auto-generated method stub
		int min = Integer.MAX_VALUE;
		for(int i=0; i<gradesList.size() ; i++){
			if(min > gradesList.get(i)){
				min = gradesList.get(i);
			}
		}
		return min;
	}

	/**
	 * Maximum of all grades.
	 *
	 * @param gradesList the grades list
	 * @return the int
	 */
	private static int maximumOfAllGrades(ArrayList<Integer> gradesList) {
		// TODO Auto-generated method stub
		int max = Integer.MIN_VALUE;
		for(int i=0; i<gradesList.size() ; i++){
			if(max < gradesList.get(i)){
				max = gradesList.get(i);
			}
		}
		return max;
	}

	/**
	 * Average of all grades.
	 *
	 * @param gradesList the grades list
	 * @return the string
	 */
	private static String averageOfAllGrades(ArrayList<Integer> gradesList) {
		// TODO Auto-generated method stub
		int average = 0;
		int size = gradesList.size();
		for(int i=0 ; i< size; i++){
			average += gradesList.get(i);
		}
		try{
			return convertToTwoDigitsAfterDecimal((float)average/(float)size);
		}catch(Exception e){
			System.out.println("Exception Caught in average of all grades");
			return null;
		}
	}
	
	/**
	 * Convert to two digits after decimal.
	 *
	 * @param decimalNumber the decimal number
	 * @return the string
	 */
	private static String convertToTwoDigitsAfterDecimal(float decimalNumber){
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		return (df.format(decimalNumber));
	}
}
