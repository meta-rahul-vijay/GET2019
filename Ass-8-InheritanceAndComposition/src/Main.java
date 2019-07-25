import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static final ArrayList<Zones> zonesList = new ArrayList<Zones>(3);
	
	public static void main(String args[]){
		System.out.println("Zoo Mangagement System");
		addZones();
		Scanner sc = new Scanner(System.in);
		ZooImplementation zoo = new ZooImplementation();
		System.out.println("0 for add cage to zone");
		System.out.println("1 for add animal to cage");
		System.out.println("2 in case of death of animal");
		System.out.println("other in case of exit from zoo");
		while(true){
			int chooseOperation = sc.nextInt();
			switch(chooseOperation){
			case 0 :
				zoo.addCageToZone();
				break;
	
			case 1 :
				zoo.addAnimalToCage();
				break;
				
			case 2 :
				zoo.deathOfAnimal();
				break;
				
			case 3 :
				zoo.View();
				break;
				
			default :
				System.out.println("\n" + "Good Bye");
		        System.exit(0);
			}
		}
		
		
	}

	private static void addZones() {
		System.out.println("Enter zone data : ");
		Scanner sc = new Scanner(System.in);
		for(int i = 0 ; i < 3 ; i++){
			Zones zone = new Zones(sc.nextInt(), sc.next(), 0, sc.nextInt(), false, false);
			zonesList.add(zone);
		}
	}
}
