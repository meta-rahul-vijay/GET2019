
public class Reptile extends Animal{
	
	public Reptile(int animalId, String animalName, int age, int weight){
		super(animalId, animalName, age, weight);
		super.category = "reptile";
	}
}
