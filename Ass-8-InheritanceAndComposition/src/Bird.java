
public class Bird extends Animal{
	
	public Bird(int animalId, String animalName, int age, int weight){
		super(animalId, animalName, age, weight);
		super.category = "bird";
	}
}
