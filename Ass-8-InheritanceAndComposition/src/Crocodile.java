
public class Crocodile extends Mammal{
	
	public Crocodile(int animalId, String animalName, int age, int weight) {
		super(animalId, animalName, age, weight);
	}
	
	
	protected String getSound() {
		return "hiss";
	}
}
