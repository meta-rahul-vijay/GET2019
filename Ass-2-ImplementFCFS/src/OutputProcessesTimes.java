import java.util.ArrayList;


public class OutputProcessesTimes {
	public void outputProcessingTimes(ArrayList<Process> processList){
		int avgWaitingTime = 0;
		int maxWaitingTimePeriodProcess = 0;
		for(int i=0 ; i<processList.size() ; i++){
			avgWaitingTime += processList.get(i).getWaitingTime();
			if(maxWaitingTimePeriodProcess < processList.get(i).getWaitingTime()){
				maxWaitingTimePeriodProcess = processList.get(i).getWaitingTime();
			}
		}
		System.out.println("Process Name\tProcess Id\tArrival Time\tBurst Time\tWaiting Time\tTurn Around Time\tCompletion Time");
		for(int i=0 ; i<processList.size() ; i++){
			System.out.println(processList.get(i).getProcessName() + "\t\t" + processList.get(i).getProcessId() + "\t\t" + 
			processList.get(i).getArrTime() + "\t\t" + processList.get(i).getBurstTime() + "\t\t" + processList.get(i).getWaitingTime() + 
			"\t\t" + processList.get(i).getTurnAroundTime() + "\t\t\t" + processList.get(i).getCompletionTime());
		}
		System.out.println("\nAverage Waiting Time = "+((float)avgWaitingTime/(float)processList.size()));
		System.out.println("\nMaximum Waiting Time Period Process = "+maxWaitingTimePeriodProcess);
	}
}
