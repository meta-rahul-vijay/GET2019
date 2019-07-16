import java.util.ArrayList;
import java.util.Scanner;


public class JobSchedular {
	public static void main(String args[]){
		ArrayList<Process> processList= new ArrayList<Process>();
		InputTime inputTime = new InputTime();
		AllProcessingTimes processingTime = new AllProcessingTimes();
		OutputProcessesTimes outputTime = new OutputProcessesTimes();
		inputTime.userInput(processList);
		processingTime.calculateProcessingTimeOfProcesses(processList);
		outputTime.outputProcessingTimes(processList);
		return;
	}
}
