package javaconnectivity;

/**
 * POJO class to hold top category info
 * @author Rahul Vijay
 */
public class Category {
	
	private String topCategoryName;
	private int numberOfChildren;
	
	
	
	public String getTopCategoryName() {
		return topCategoryName;
	}
	public void setTopCategoryName(String topCategoryName) {
		this.topCategoryName = topCategoryName;
	}
	
	
	public int getNumberOfChildren() {
		return numberOfChildren;
	}
	public void setNumberOfChildren(int numberOfChildren) {
		this.numberOfChildren = numberOfChildren;
	}
}

