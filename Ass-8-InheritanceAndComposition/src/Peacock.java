
public class Peacock extends Mammal{
	
	public Peacock(int animalId, String animalName, int age, int weight) {
		super(animalId, animalName, age, weight);
	}
	
	
	protected String getSound() {
		return "scream";
	}
}
