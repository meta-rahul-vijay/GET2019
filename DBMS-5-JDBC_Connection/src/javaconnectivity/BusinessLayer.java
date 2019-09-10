package javaconnectivity;

import java.util.*;
import java.sql.*;

/**
 * class  to  execute SQL statements
 * @author Rahul Vijay
 */
public class BusinessLayer {

	/**
	 * method to fetch order details of given shopper 
	 * @param dl is object  of DataLayer
	 * @param shopperId
	 * @return {List<Order>} containing order details
	 * @throws SQLException
	 */
	public List<Orders> fetchOrderDetails(DataLayer dl , int shopperId) throws SQLException {
		
		List<Orders> orderList = new ArrayList<Orders>();
		
		ResultSet rset;
		
		
        dl.setStatement("CALL shipped_State(?,'Shipped')");
        
        dl.getStatement().setInt(1, shopperId);
        rset = dl.getStatement().executeQuery();
        
        while(rset.next()) {
        	Orders obj = new Orders();
        	obj.setOrderId(rset.getInt(1));
        	obj.setOrderDate(rset.getString(2));
        	obj.setOrderTotalPrice(rset.getInt(3));
        	orderList.add(obj);
        }
        return orderList;

	}
	
	/**
	 * 
	 * @param dl is object  of DataLayer
	 * @throws SQLException
	 */
	public void insertIntoImage(DataLayer dl,int pId) throws SQLException{

		dl.setStatement("INSERT INTO images VALUES(?,?)");

		for(int i=1; i <= 5; i++){
			dl.getStatement().setInt(1,pId);
			dl.getStatement().setString(2,"newImage"+Integer.toString(i));
			dl.getStatement().addBatch();
			dl.getStatement().clearParameters();
		}
		dl.getStatement().executeBatch();
	}
	
	/**
	 * delete details from product
	 * @param dl is object  of DataLayer
	 * @return no of rows deleted
	 * @throws SQLException
	 */
	public int UpdateProduct(DataLayer dl) throws SQLException{

		dl.setStatement("CALL delete_product()");

		int rowAffected = dl.getStatement().executeUpdate();
		return rowAffected;
	}
	
	/**
	 * method to fetch top categories and count of their subcategory
	 * @param dl is object  of DataLayer
	 * @return {List<Category>} containing top categories  
	 * @throws SQLException
	 */
	public List<Category> getTopCategory(DataLayer dl) throws SQLException{

		List<Category> categoryList = new ArrayList<>();

		ResultSet rset;
		dl.setStatement("CALL category_title()");

		rset = dl.getStatement().executeQuery();

		while(rset.next()) {
			Category obj = new Category();
			obj.setTopCategoryName(rset.getString(1));
			obj.setNumberOfChildren(rset.getInt(2));
			categoryList.add(obj);
		}
		return categoryList;

	}
}