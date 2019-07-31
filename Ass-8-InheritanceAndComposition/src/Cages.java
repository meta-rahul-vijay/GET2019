import java.util.ArrayList;


public class Cages {
	private int cageId;
	private String typeOfAnimals;
	private int cageLimit;
	private int cageSize;
	private ArrayList<Animal> listOfAnimals = new ArrayList<Animal>();
	
	public Cages(int cageId, int cageLimit, String typeOfAnimals) {
		this.cageId = cageId;
		this.cageLimit = cageLimit;
		this.typeOfAnimals = typeOfAnimals;
	}
	public int getCageSize() {
		return cageSize;
	}
	public void setCageSize(int cageSize) {
		this.cageSize = cageSize;
	}
	public int getCageId() {
		return cageId;
	}
	public void setCageId(int cageId) {
		this.cageId = cageId;
	}
	public String getTypeOfAnimals() {
		return typeOfAnimals;
	}
	public void setTypeOfAnimals(String typeOfAnimals) {
		this.typeOfAnimals = typeOfAnimals;
	}
	public int getCageLimit() {
		return cageLimit;
	}
	public void setCageLimit(int cageLimit) {
		this.cageLimit = cageLimit;
	}
	public ArrayList<Animal> getListOfAnimals() {
		return listOfAnimals;
	}
	public void setListOfAnimals(ArrayList<Animal> listOfAnimals) {
		this.listOfAnimals = listOfAnimals;
	}
}
