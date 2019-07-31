import java.util.ArrayList;


public class Zones {
	private int zoneId;
	private String category;
	private int cages;
	private int maximumCages;
	private boolean hasPark;
	private boolean hasCanteen;
	private ArrayList<Cages> listOfCages = new ArrayList<Cages>();
	private ArrayList<Animal> allPossibleAnimals;
	
	public Zones(int zoneId, String category, int cages, int maximumCages,
			boolean hasPark, boolean hasCanteen) {
		this.zoneId = zoneId;
		this.category = category;
		this.cages = cages;
		this.maximumCages = maximumCages;
		this.hasPark = hasPark;
		this.hasCanteen = hasCanteen;
		/*this.listOfCages = listOfCages;
		this.allPossibleAnimals = allPossibleAnimals;*/
	}
	
	public int getZoneId() {
		return zoneId;
	}
	public void setZoneId(int zoneId) {
		this.zoneId = zoneId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getCages() {
		return cages;
	}
	public void setCages(int cages) {
		this.cages = cages;
	}
	public int getMaximumCages() {
		return maximumCages;
	}
	public void setMaximumCages(int maximumCages) {
		this.maximumCages = maximumCages;
	}
	public boolean isHasPark() {
		return hasPark;
	}
	public void setHasPark(boolean hasPark) {
		this.hasPark = hasPark;
	}
	public boolean isHasCanteen() {
		return hasCanteen;
	}
	public void setHasCanteen(boolean hasCanteen) {
		this.hasCanteen = hasCanteen;
	}
	public ArrayList<Cages> getListOfCages() {
		return listOfCages;
	}
	public void setListOfCages(ArrayList<Cages> listOfCages) {
		this.listOfCages = listOfCages;
	}
	public ArrayList<Animal> getAllPossibleAnimals() {
		return allPossibleAnimals;
	}
	public void setAllPossibleAnimals(ArrayList<Animal> allPossibleAnimals) {
		this.allPossibleAnimals = allPossibleAnimals;
	}
}
