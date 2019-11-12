package com.parkingsystem.dao;

import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import com.parkingsystem.factory.DatabaseQuery;
import com.parkingsystem.model.dto.EmployeeDTO;
import com.parkingsystem.model.dto.FriendDTO;
import com.parkingsystem.model.pojo.EmployeePOJO;
import com.parkingsystem.service.EmployeeMapper;
import com.parkingsystem.service.FriendListMapper;
import com.parkingsystem.service.FriendMapper;
import com.parkingsystem.service.SingleStringMapper;
import com.parkingsystem.factory.ConnectionFactory;

/**
 * This dao class of employee
 * @author Rahul
 *
 */
public class EmployeeDAO {

	//Singleton object of EmployeeDAO
	private static EmployeeDAO employeeDAO = null;
	//Object of JdbcTemplate
	private static JdbcTemplate jdbcTemplate = null;

	/**
	 * This method return object EmployeeDAO
	 * @return object EmployeeDAO
	 */
	public static EmployeeDAO getInstance(){

		if(employeeDAO == null){
			employeeDAO = new EmployeeDAO();
		}
		if(jdbcTemplate == null) {
			try {
				jdbcTemplate = new JdbcTemplate(new SingleConnectionDataSource(ConnectionFactory.getConnection() , true));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return employeeDAO;
	}

	/**
	 * This method add employee details to database
	 * @param employee object of EmployeePOJO containing employee details
	 * @throws SQLException exception related to database
	 * @throws Exception other general exception
	 */
	public int addEmployee(EmployeePOJO employeePOJO) {

		int result = jdbcTemplate.update(DatabaseQuery.ADD_EMPLOYEE, employeePOJO.getName(),employeePOJO.getGender(),employeePOJO.getEmail(),employeePOJO.getPassword(),employeePOJO.getPhoneNumber(),Integer.parseInt(employeePOJO.getCompany()));
		if(result > 0){
			return result;
		}else{
			return -1;
		}
	}

	/**
	 * This method use to get employee details from database
	 * @param email email of employee
	 * @return object of EmployeeDTO containing details of employee
	 * @throws SQLException database related exception
	 * @throws Exception other general exception
	 */
	public EmployeeDTO getEmployeeDetail(String email) throws SQLException,Exception{

		return jdbcTemplate.queryForObject(DatabaseQuery.GET_EMPLOYEE_DETAIL,new EmployeeMapper(),email);

	}


	/**
	 * This method get details of employee friend
	 * @param email email of employee
	 * @return object of FriendDTO containing details of friend
	 * @throws SQLException exception related to database
	 * @throws Exception other general exception
	 */
	public FriendDTO getFriendDetail(String email) throws SQLException,Exception{

		return jdbcTemplate.queryForObject(DatabaseQuery.GET_FRIEND_DETAIL, new FriendMapper(),email);
	}

	/**
	 * This method is use to update detail of employee in database
	 * @param employee object of EmployeePOJO containing details of employee
	 * @param email email of employee
	 * @return true if updated else false
	 * @throws SQLException exception related to database
	 * @throws Exception other general exception
	 */
	public boolean updateEmployeeDetail(EmployeePOJO employeePOJO,String email) throws SQLException,Exception{

		int result = jdbcTemplate.update(DatabaseQuery.UPDATE_EMPLOYEE_DETAIL, employeePOJO.getEmail(),employeePOJO.getPassword(),employeePOJO.getPhoneNumber(),email);
		if(result > 0){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * This method is use to get the list of friends of employee
	 * @param email email of employee
	 * @return List of FriendDTO 
	 * @throws SQLException exception related to database
	 * @throws Exception other general exception
	 */
	public List<FriendDTO> getFriendList(String email) throws SQLException,Exception{

		return jdbcTemplate.queryForObject(DatabaseQuery.GET_FRIENDS_LIST,new FriendListMapper(),email);
	}

	/**
	 * This method is use to get the employee id
	 * @param email email of employee
	 * @return integer id of employee
	 * @throws SQLException exception related to database
	 * @throws Exception other general exception
	 */
	public int getEmployeeId(String email) throws SQLException,Exception{

		return jdbcTemplate.queryForObject(DatabaseQuery.GET_EMPLOYEE_ID, Integer.class, email);
	}
	
	/**
	 * This method update profile photo url in database
	 * @param email of employee
	 * @param url of profile photo
	 * @return true if added else false
	 * @throws SQLException exception related to database
	 * @throws Exception other general exception
	 */
	public boolean updatePhotoUrl(String email,String url) throws SQLException,Exception{
		
		int result =0;
		try {
			result = jdbcTemplate.update(DatabaseQuery.UPDATE_PHOTO_URL,email,url);
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(result > 0) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * This method return the url of profile photo
	 * @param email of employee
	 * @return url of profile photo
	* @throws SQLException exception related to database
	 * @throws Exception other general exception
	 */
	public String getPhotoUrl(String email) throws SQLException,Exception{
		
		return jdbcTemplate.queryForObject(DatabaseQuery.GET_PHOTO_URL, new SingleStringMapper(), email);
	}
}
