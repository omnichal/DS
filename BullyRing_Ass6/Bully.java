import java.util.*;

public class Bully{

	public static void main(String[] args){
		int initiator = -1, leader = -1;
		boolean leaderAlive = false;
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the number of processes: ");
		int numberOfProcesses = sc.nextInt();
		List<Integer> processes = new ArrayList<>();

		for(int i = 1; i <= numberOfProcesses; i++){
			processes.add(i);
		}
		System.out.println("The processes are: " + processes);
		System.out.print("Enter the Leader Process No: ");
		leader = sc.nextInt();

		System.out.print("Enter the process that starts the communication: ");
		initiator = sc.nextInt();

		while(!leaderAlive){
			if(initiator == leader){
				initiator++;
			}
			int newLeader = electLeader(initiator, leader, processes);

			if(newLeader != 0){
				System.out.println("Process " + newLeader + " is elected as the new Leader.");
				leaderAlive = true;
			}
			initiator++;
		}
	}

	public static int electLeader(int initiator, int leader, List<Integer> processes){
		int count = 0;
		System.out.println("Process " + initiator + " is starting the election.");
		for(int i = initiator; i < processes.size(); i++){
			System.out.println("Sending election message to process " + processes.get(i));
			if(processes.get(i) == leader){
				System.out.println("Process " + processes.get(i) + "is down.");
			}else{
				System.out.println("Process " + processes.get(i) + "has Acknowledged.");
				count++;
			}
		}

		if(count == 1){
			if(processes.get(initiator) == leader){
				return processes.get(initiator - 1);
			}
			return processes.get(initiator);
		}else{
			return 0;
		}
	}
}
