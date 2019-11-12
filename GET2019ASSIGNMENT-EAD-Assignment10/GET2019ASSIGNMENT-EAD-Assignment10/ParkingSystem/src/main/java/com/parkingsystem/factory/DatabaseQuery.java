package com.parkingsystem.factory;

/**
 * This class contain database query
 * @author Rahul
 *
 */
public class DatabaseQuery {

	//This is for checking user access
	public static final String CHECK_LOGIN = "SELECT login(?,?);";
	// This is for getting employee details
	public static final String GET_EMPLOYEE_DETAIL = "CALL getEmployeeDetails(?)";
	// This is for updating employee details
	public static final String UPDATE_EMPLOYEE_DETAIL = "CALL updateEmployeeDetails(?,?,?,?)";
	// This is for adding employee
	public static final String ADD_EMPLOYEE = "CALL addEmployee(?,?,?,?,?,?)";
	// This is for getting id of last added employee
	public static final String GET_ID_OF_ADDED_EMPLOYEE = "SELECT getIdOfAddedEmployee();";
	// This is for adding vehicle
	public static final String ADD_VEHICLE ="CALL addVehicle(?,?,?,?,?)";
	// This is for adding plan
	public static final String ADD_PLAN = "CALL addPlan(?,?,?,?)";
	// This is for getting friend list of employee
	public static final String GET_FRIENDS_LIST = "CALL getFriendList(?)";
	// This is for getting friend detail of employee
	public static final String GET_FRIEND_DETAIL = "CALL getFriendDetails(?)";
	// This is for getting employee id
	public static final String GET_EMPLOYEE_ID = "SELECT getEmployeeId(?);";
	// This is for getting vehicle id
	public static final String GET_VEHICLE_ID = "SELECT getVehicleId(?);";
	// This is for getting plan id
	public static final String GET_PLAN_ID = "SELECT getPlanId(?);";
	// This is for getting vehicle type
	public static final String GET_VEHICLE_TYPE = "SELECT getVehicleType(?);";
	// This is for updating profile photo url
	public static final String UPDATE_PHOTO_URL = "CALL updatePhotoUrl(?,?)";
	// This is for getting profile photo url
	public static final String GET_PHOTO_URL = "SELECT getPhotoUrl(?)";
}
