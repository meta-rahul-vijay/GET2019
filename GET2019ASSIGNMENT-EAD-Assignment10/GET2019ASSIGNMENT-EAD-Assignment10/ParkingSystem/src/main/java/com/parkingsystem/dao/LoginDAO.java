package com.parkingsystem.dao;

import java.sql.SQLException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import com.parkingsystem.factory.DatabaseQuery;
import com.parkingsystem.model.pojo.LoginPOJO;
import com.parkingsystem.service.SingleIntegerMapper;
import com.parkingsystem.factory.ConnectionFactory;

public class LoginDAO {

	//Singleton object of LoginDAO
	private static LoginDAO loginDAO = null;
	//Object of JdbcTemplate
	private static JdbcTemplate jdbcTemplate = null;

	/**
	 * This method return object of LoginDAO
	 * @return object of LoginDAO
	 */
	public static LoginDAO getInstance(){

		if(loginDAO == null){
			loginDAO = new LoginDAO();
		}
		if(jdbcTemplate == null) {
			try {
				jdbcTemplate = new JdbcTemplate(new SingleConnectionDataSource(ConnectionFactory.getConnection() , true));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return loginDAO;
	}

	/**
	 * This method authenticate user details 
	 * @param loginPOJO object of LoginPOJO class
	 * @return true if user details are correct else false
	 */
	public boolean login(LoginPOJO loginPOJO) throws SQLException, Exception{

		int result = jdbcTemplate.queryForObject(DatabaseQuery.CHECK_LOGIN, new SingleIntegerMapper(), loginPOJO.getEmail(),loginPOJO.getPassword());
		if(result == 1){
			return true;
		}else{
			return false;
		}
	}
}
