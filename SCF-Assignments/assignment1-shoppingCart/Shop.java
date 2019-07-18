import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Shop {
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		
        HashMap<String, Integer> mapItemsToPrice = new HashMap<>();
        mapItemsToPrice.put("Bread", 15); 
        mapItemsToPrice.put("Butter", 30); 
        mapItemsToPrice.put("Milk", 20);
        mapItemsToPrice.put("Egg", 8);
        mapItemsToPrice.put("Jam", 50);

		System.out.println("Welcome to the largest Shopping Cart\n");
		Cart shoppingCart = new Cart();

		while(true){
			System.out.println("\npress 0 for exit");
			System.out.println("press 1 for add item in the cart");
			System.out.println("press 2 for remove item from the cart");
			System.out.println("press 3 for display items of the cart");
			System.out.println("press 4 for generate bill of the cart items\n");			
			
			int select = sc.nextInt();
			
			switch(select){
			case 0 : 
				System.out.println("\n" + "Good Bye");
	            System.exit(0);
			
			case 1 :
				System.out.println("Items" + '\t' + "Price" + '\n');
				System.out.println("Bread" + '\t' + mapItemsToPrice.get("Bread"));
				System.out.println("Butter" + '\t' + mapItemsToPrice.get("Butter"));
				System.out.println("Milk" + '\t' + mapItemsToPrice.get("Milk"));
				System.out.println("Egg" + '\t' + mapItemsToPrice.get("Egg"));
				System.out.println("Jam" + '\t' + mapItemsToPrice.get("Jam"));
				
				String itemName = sc.next();
				int itemQty = sc.nextInt();
				shoppingCart.addItem(itemName, itemQty, mapItemsToPrice.get(itemName));
				break;
				
			case 2 : 
				System.out.println("Enter item to remove");
				String itemToRemove = sc.next();
				shoppingCart.removeItem(itemToRemove);
				break;
				
			case 3 : 
				shoppingCart.displayCartItems();
				break;
				
			case 4 :
				shoppingCart.generateCartBill();
				break;
			
			default : 
				System.out.println("Try again");
				break;
			}
		}
		   
	}

}
