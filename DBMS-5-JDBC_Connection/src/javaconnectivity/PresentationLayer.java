package javaconnectivity;

import java.sql.SQLException;
import java.util.*;
/**
 * Main class
 * @author Rahul Vijay
 */
public class PresentationLayer {

	public static void main(String s[]){

		Scanner inputObj = new Scanner(System.in);

		DataLayer dl=new DataLayer();
		dl.setDriver("com.mysql.jdbc.Driver") ;
		dl.setConnection("jdbc:mysql://localhost:3309/test","root","admin");

		BusinessLayer bl=new BusinessLayer();

		System.out.println("Enter the id of shopper to see order details ");
		int sId=inputObj.nextInt();
		//fetching order details and printing them
		List<Orders> orderList = new ArrayList<>();
		try {
			orderList = bl.fetchOrderDetails(dl,sId);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("\nOrder id \t order date \t total price");
		for(int index = 0; index < orderList.size(); index++){
			System.out.println(orderList.get(index).getOrderId()
					+" \t " +  orderList.get(index).getOrderDate()
					+" \t " +  orderList.get(index).getOrderTotalPrice());
		}

		System.out.println("\nEnter product id to add images : ");
		int pId = inputObj.nextInt();
		//inserting images
		try {
			bl.insertIntoImage(dl,pId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("\nimages added sucessfully");

		//deleting products
		System.out.println("\ndeleting products not ordered in last 1 year.. ");
		try {
			System.out.println("\nnumber of rows affected : "+bl.UpdateProduct(dl));
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//fetching top category and printing them
		System.out.println("\ndetails of top category");
		List<Category> categoryList = new ArrayList<>();
		try {
			categoryList = bl.getTopCategory(dl);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("\nTop category \t\t number of items");
		for(int index = 0; index < orderList.size(); index++){
			System.out.println(categoryList.get(index).getTopCategoryName()
					+" \t\t " +  categoryList.get(index).getNumberOfChildren());
		}

	}
}