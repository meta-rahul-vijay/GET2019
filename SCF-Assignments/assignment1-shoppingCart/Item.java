
public class Item {
	private String itemName;
	private int itemQty;
	private double itemPrice; 
	
	public Item (String name, int qty, double price){
		itemName = name;
		itemQty = qty;
		itemPrice = price;
	}
	
	public double getItemPrice() {
		return itemPrice;
	}
	public String getItemName() {
		return itemName;
	}
	public int getItemQty() {
		return itemQty;
	}
	
}
