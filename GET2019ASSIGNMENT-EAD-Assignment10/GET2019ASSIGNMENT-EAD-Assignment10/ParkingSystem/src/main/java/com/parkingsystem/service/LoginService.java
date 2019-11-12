package com.parkingsystem.service;

import com.parkingsystem.dao.LoginDAO;
import com.parkingsystem.model.pojo.LoginPOJO;

/**
 * This is service class for login
 * @author Rahul
 *
 */
public class LoginService {

	private static LoginService loginFacade = null;
	
	public static LoginService getInstance(){
		
		if(loginFacade == null){
			loginFacade = new LoginService();
		}
		return loginFacade;
	}
	
	/**
	 * This method authenticate user details 
	 * @param user object of User class
	 * @return true if user details are correct else false
	 */
	public boolean login(LoginPOJO loginPOJO) throws Exception{
		
		LoginDAO loginDAO = LoginDAO.getInstance();
		try{
		 return loginDAO.login(loginPOJO);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}
}
