package com.parkingsystem.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.parkingsystem.model.dto.EmployeeDTO;

/**
 * This is Employee Mapper class
 * @author Rahul
 *
 */
public class EmployeeMapper implements RowMapper<EmployeeDTO>{
	
	/**
	 * This method map the result set to employeeDTO object
	 * @param rs object of ResultSet containing data from database query
	 * @param rowNum int containing total row in ResultSet
	 * @return object of EmployeeDTO 
	 */
	@Override
	public EmployeeDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setId(rs.getInt(1));
		employeeDTO.setName(rs.getString(2));
		employeeDTO.setGender(rs.getString(3));
		employeeDTO.setEmail(rs.getString(4));
		employeeDTO.setPassword(rs.getString(5));
		employeeDTO.setPhoneNumber(rs.getString(6));
		employeeDTO.setCompany(rs.getString(7));
		return employeeDTO;
	}

}
