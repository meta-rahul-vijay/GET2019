import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class Cart {
	
	private int itemCount;
	private static double totalPrice;
	private static int capacity;
	private static ArrayList<Item> cart;
    static Set<String> setOfItemsInCart= new HashSet<String>(); 

	
	public Cart(){
		itemCount = 0;
		totalPrice = 0.0;
		capacity = 10;
	    cart = new ArrayList<Item>();
	}
			
	public void addItem(String itemName, int itemQty, double itemPrice){
		if(setOfItemsInCart.contains(itemName)){
			System.out.println("This item is already in cart, you can update quantity of item if you want");
			return;
		}
		Item newItem = new Item(itemName, itemQty, itemPrice);
	    cart.add(newItem);
		setOfItemsInCart.add(newItem.getItemName());
	    totalPrice += (newItem.getItemQty() * newItem.getItemPrice());
		itemCount++;
		if(itemCount == capacity){
			increaseSizeOfCart();
		}
		return;

	}
	
	public void removeItem(String itemName){

	    for (int i = 0; i < cart.size(); i++) {
	        Item remove = cart.get(i);
	        if (itemName.equals(remove.getItemName())) {
	        	totalPrice -= remove.getItemPrice()*remove.getItemQty();
	            cart.remove(i);
	            setOfItemsInCart.remove(remove.getItemName()); 
	            return;
	        }
	    }
	    System.out.println("\n" + "Item " + itemName + " wasn't found.");
	    return;
	}
	
	private void increaseSizeOfCart() {
		ArrayList<Item> item = new ArrayList<Item>(capacity + 5);
	    for(int i=0; i < capacity; i++)
	    {
	        item.add(cart.get(i));
	    }
	    cart = item; 
	    item = null;
	    capacity = cart.size();
	}
	
	public void displayCartItems(){
		if(cart.size() == 0){
			System.out.println("Cart is EMPTY");
			return;
		}
		System.out.println("Cart Items\n");
		System.out.println("Item Name" + "\t" + "Item Quantity" + "\t" + "Item Price\n");
		for(int i=0 ; i<cart.size();i++){
			Item printItem = cart.get(i);
			System.out.println(printItem.getItemName() + "\t\t" + printItem.getItemQty() + "\t\t" + printItem.getItemPrice());
		}
		return;
	}
	
	public void generateCartBill(){
		System.out.println("Your Cart Bill\n");
		System.out.println("Total Price : \t"+totalPrice);
		return;
	}
	
}
