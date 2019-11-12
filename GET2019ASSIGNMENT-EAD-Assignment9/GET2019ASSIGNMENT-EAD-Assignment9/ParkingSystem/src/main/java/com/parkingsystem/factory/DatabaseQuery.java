package com.parkingsystem.factory;

public class DatabaseQuery {

	//This is for checking user access
	public static final String CHECK_LOGIN = "SELECT login(?,?);";
	public static final String GET_EMPLOYEE_DETAIL = "{CALL getEmployeeDetails(?)}";
	public static final String UPDATE_EMPLOYEE_DETAIL = "{CALL updateEmployeeDetails(?,?,?,?)}";
	public static final String ADD_EMPLOYEE = "{CALL addEmployee(?,?,?,?,?,?)}";
	public static final String GET_ID_OF_ADDED_EMPLOYEE = "SELECT getIdOfAddedEmployee();";
	public static final String ADD_VEHICLE ="{CALL addVehicle(?,?,?,?,?)}";
	public static final String ADD_PLAN = "{CALL addPlan(?,?,?,?)}";
	public static final String GET_FRIENDS_LIST = "{CALL getFriendList(?)}";
	public static final String GET_FRIEND_DETAIL = "{CALL getFriendDetails(?)}";
	public static final String GET_EMPLOYEE_ID = "SELECT getEmployeeId(?);";
	public static final String GET_VEHICLE_ID = "SELECT getVehicleId(?);";
	public static final String GET_PLAN_ID = "SELECT getPlanId(?);";
	public static final String GET_VEHICLE_TYPE = "SELECT getVehicleType(?);";
}
