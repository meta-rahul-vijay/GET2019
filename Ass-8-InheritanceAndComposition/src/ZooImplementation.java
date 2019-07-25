import java.awt.List;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.Iterator;


public class ZooImplementation {
	static int cageId = 0;
	static int animalId = 0; 
	public void addCageToZone(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter zone id : ");
		int zoneId = sc.nextInt();
		Zones zone = null;
		for(int i = 0 ; i < Main.zonesList.size() ; i++){
			zone = Main.zonesList.get(i);
			if(zone.getZoneId() == zoneId){
				break;
			}
		}
		if(zone != null){
			if(zone.getListOfCages().size() > zone.getMaximumCages()){
				System.out.println("Can't add cage to this zone");
				return;
			}
			cageId++;
			Cages cage = new Cages(cageId, sc.nextInt(), sc.next());
			zone.getListOfCages().add(cage);
		}
	}
	
	public void addAnimalToCage(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter animal name to add : ");
		String animalName = sc.next();
		
		Zones zone;
		for(int j = 0 ; j < 3 ; j++){
			zone = Main.zonesList.get(j);
			animalId++;
			Animal animal = null;
			if("lion".equalsIgnoreCase(animalName)){
				animal = new Lion(animalId, animalName, sc.nextInt(), sc.nextInt());
			}
			else if("peacock".equalsIgnoreCase(animalName)){
				animal = new Peacock(animalId, animalName, sc.nextInt(), sc.nextInt());
			}
			else if("crocodile".equalsIgnoreCase(animalName)){
				animal = new Crocodile(animalId, animalName, sc.nextInt(), sc.nextInt());
			}
			//String category = Animal.category;
			//String zoneCategory = zone.getCategory();
			if(!animal.category.equalsIgnoreCase(zone.getCategory())){
				animal = null;
				continue;
			}
			ArrayList<Cages> cagesList = zone.getListOfCages();
			for(int i = 0 ; i < cagesList.size() ; i++){
				/*if(cagesList.get(i).getTypeOfAnimals() == null && cagesList.get(i).getCageSize() < cagesList.get(i).getCageLimit()){
					cagesList.get(i).getListOfAnimals().add(animal);
					cagesList.get(i).setTypeOfAnimals(animal.getAnimalName());
					cagesList.get(i).setCageSize(cagesList.get(i).getCageSize() + 1);
					return;
				}*/if(animalName.equalsIgnoreCase(cagesList.get(i).getTypeOfAnimals()) && cagesList.get(i).getCageSize() < cagesList.get(i).getCageLimit()){
					cagesList.get(i).getListOfAnimals().add(animal);
					cagesList.get(i).setCageSize(cagesList.get(i).getCageSize() + 1);
					return;
				}
			}	
		}
		
		System.out.println("Cage is full can't add animal");
		return;
	}
	public void deathOfAnimal(){
		Scanner sc = new Scanner(System.in);
		String animalName = sc.next();
		int animalId = sc.nextInt();
		
		for(int j = 0 ; j < 3 ; j++){
			Zones zone = Main.zonesList.get(j);
			
			ArrayList<Cages> cagesList = zone.getListOfCages();
			
			for(int i = 0 ; i < cagesList.size() ; i++){
				if(animalName.equalsIgnoreCase(cagesList.get(i).getTypeOfAnimals())){
					ArrayList<Animal> animalsList = cagesList.get(i).getListOfAnimals();
					java.util.Iterator<Animal> itr = animalsList.iterator();// might be error in this 
					while (itr.hasNext()) 
			        { 
			            Animal x = (Animal)itr.next(); 
			            if (x.getAnimalId() == animalId){
			            	itr.remove();
			            	cagesList.get(i).setCageSize(cagesList.get(i).getCageSize() - 1);
			            	return;
			            } 
			        } 				
				}
			}
		}
		System.out.println("No dead animal found");
		return;
	}

	public void View() {
		for(int i = 0 ; i < 3 ; i++){
			Zones zone = Main.zonesList.get(i);
			System.out.println("zoneId = "+zone.getZoneId() + "\tcategory = "+zone.getCategory() + "\tcages = "+zone.getCages() + "\tmaximumCages = "+zone.getMaximumCages());
			ArrayList<Cages> cagesList = zone.getListOfCages();
			for(int j = 0 ; j < cagesList.size() ; j++){
				Cages cage = cagesList.get(j);
				System.out.println("cageId = "+cage.getCageId()+ "\tcageLimit = "+cage.getCageLimit()+ "\tcageSize = "+cage.getCageSize()+ "\ttypeOfAnimals = "+cage.getTypeOfAnimals()+ "\tlistOfAnimals = "+cage.getListOfAnimals());
			}
		}
	}
	
}
