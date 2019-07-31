public class Animal{
	private int animalId;
	private String animalName;
	protected String category;
	private int age;
	private int weight;
	
	public Animal(int animalId, String animalName, int age, int weight){
		this.animalId = animalId;
		this.animalName = animalName;
		this.age = age;
		this.weight = weight;
	}
	
	public int getAnimalId() {
		return animalId;
	}
	public void setAnimalId(int animalId) {
		this.animalId = animalId;
	}
	public String getAnimalName() {
		return animalName;
	}
	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
}