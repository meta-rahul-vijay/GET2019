
public class Lion extends Mammal{
	
	public Lion(int animalId, String animalName, int age, int weight) {
		super(animalId, animalName, age, weight);
	}
	
	
	protected String getSound() {
		return "roar";
	}
}
