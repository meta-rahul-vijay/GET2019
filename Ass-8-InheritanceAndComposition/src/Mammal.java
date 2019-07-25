
public class Mammal extends Animal{
	
	public Mammal(int animalId, String animalName, int age, int weight){
		super(animalId, animalName, age, weight);
		super.category = "mammal";
	}
}
