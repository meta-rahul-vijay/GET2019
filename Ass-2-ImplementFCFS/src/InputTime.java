import java.util.ArrayList;
import java.util.Scanner;


public class InputTime {
	public void userInput(ArrayList<Process> processList){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of process");
		int numOfProcess = sc.nextInt();
		for(int i=0 ; i<numOfProcess ; i++){
			Process process = new Process();
			System.out.println("\nEnter arrival and burst time of process P" + i);
			int arrivalTime = sc.nextInt();
			int burstTime = sc.nextInt();
			process.setProcessName("P"+i);
			process.setProcessId(i);
			process.setArrTime(arrivalTime);
			process.setBurstTime(burstTime);
			processList.add(process);
		}
	}
}
