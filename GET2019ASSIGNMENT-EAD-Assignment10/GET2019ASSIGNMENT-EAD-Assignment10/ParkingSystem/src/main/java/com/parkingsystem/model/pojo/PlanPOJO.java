package com.parkingsystem.model.pojo;

import javax.validation.constraints.NotBlank;

public class PlanPOJO {

	@NotBlank
	private String type;
	
	@NotBlank
	private String price;
	
	@NotBlank
	private String currency;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
}
