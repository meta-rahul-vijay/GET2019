package com.parkingsystem.model.pojo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class VehiclePOJO {

	private int empId;
	
	@NotBlank(message="${vehicleName.NotBlank}")
	private String name;
	
	@NotBlank(message="${vehicleType.NotBlank}")
	@Pattern(regexp="[a-zA-Z]+",message="${vehicleType.Invalid}")
	private String type;
	
	@NotBlank(message="${vehicleNumber.NotBlank}")
	private String number;
	
	@NotBlank(message="'${vehicleIdentification.NotBlank}")
	private String identification;
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getIdentification() {
		return identification;
	}
	public void setIdentification(String identification) {
		this.identification = identification;
	}
}
