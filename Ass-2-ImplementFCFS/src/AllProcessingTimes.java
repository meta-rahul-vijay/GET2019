import java.util.ArrayList;


public class AllProcessingTimes {
	public void calculateProcessingTimeOfProcesses(ArrayList<Process> processList){
		int listLength = processList.size();
		waitingTimeOfProcesses(processList);
		TurnAroundTimeOfProcesses(processList);
		completionTimeOfProcesses(processList);
	}
	
	private void completionTimeOfProcesses(ArrayList<Process> processList) {
		for(int i=0 ; i<processList.size() ; i++){
			processList.get(i).setCompletionTime(processList.get(i).getArrTime() + processList.get(i).getTurnAroundTime());
		}
	}

	private void TurnAroundTimeOfProcesses(ArrayList<Process> processList) {
		for(int i=0 ; i<processList.size() ; i++){
			processList.get(i).setTurnAroundTime(processList.get(i).getBurstTime() + processList.get(i).getWaitingTime());
		}
	}

	public void waitingTimeOfProcesses(ArrayList<Process> processList){
	    int serviceTime[] = new int[processList.size()];  
	    serviceTime[0] = 0;
		processList.get(0).setWaitingTime(0);
		for(int i=1 ; i<processList.size() ; i++){
	        serviceTime[i] = serviceTime[i-1] + processList.get(i-1).getBurstTime();  
			processList.get(i).setWaitingTime(serviceTime[i] - processList.get(i).getArrTime());
			
			if(processList.get(i).getWaitingTime() < 0){
				processList.get(i).setWaitingTime(0);
			}
		}
	}
}
