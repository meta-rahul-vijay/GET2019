package com.Metacube.EAD_4;

public class VehicleForm {
	private String name;
	private String type;
	private int vehicleNumber;
	private int employeeId;
	private String identification;
	
	
	public VehicleForm(String name, String type, int vehicleNumber,
			int employeeId, String identification) {
		super();
		this.name = name;
		this.type = type;
		this.vehicleNumber = vehicleNumber;
		this.employeeId = employeeId;
		this.identification = identification;
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
	public int getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(int vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getIdentification() {
		return identification;
	}
	public void setIdentification(String identification) {
		this.identification = identification;
	}
	@Override
	public String toString() {
		return "VehicleForm [name=" + name + ", type=" + type
				+ ", vehicleNumber=" + vehicleNumber + ", employeeId="
				+ employeeId + ", identification=" + identification + "]";
	}

}
