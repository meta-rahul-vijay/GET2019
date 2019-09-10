package javaconnectivity;
/**
 * POJO class to hold order details
 * @author Rahul Vijay
 */
public class Orders {
	
	private int orderId ;
	private String orderDate;
	private int orderTotalPrice;
	
	public int getOrderId() {
		return orderId;
	}	
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	
	public int getOrderTotalPrice() {
		return orderTotalPrice;
	}
	public void setOrderTotalPrice(int orderTotalPrice) {
		this.orderTotalPrice = orderTotalPrice;
	}
}
