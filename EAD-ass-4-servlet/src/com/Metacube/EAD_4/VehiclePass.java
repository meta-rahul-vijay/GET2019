package com.Metacube.EAD_4;

public class VehiclePass {
	int empId;
	String empName;
	String vehType;
	int vehNo;
	String planType;
	float vehPrice;
	
	public VehiclePass(int empId, String empName, String vehType, int vehNo,
			String planType, float vehPrice) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.vehType = vehType;
		this.vehNo = vehNo;
		this.planType = planType;
		this.vehPrice = vehPrice;
	}
	

	public float getVehPrice() {
		return vehPrice;
	}

	public void setVehPrice(float vehPrice) {
		this.vehPrice = vehPrice;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getVehType() {
		return vehType;
	}

	public void setVehType(String vehType) {
		this.vehType = vehType;
	}

	public int getVehNo() {
		return vehNo;
	}

	public void setVehNo(int vehNo) {
		this.vehNo = vehNo;
	}

	public String getPlanType() {
		return planType;
	}

	public void setPlanType(String planType) {
		this.planType = planType;
	}

	@Override
	public String toString() {
		return "VehiclePass [empId=" + empId + ", empName=" + empName
				+ ", vehType=" + vehType + ", vehNo=" + vehNo + ", planType="
				+ planType + ", vehPrice=" + vehPrice + "]";
	}
	
	
}
