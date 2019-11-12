package com.parkingsystem.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * This is mapper class for String
 * @author Rahul
 *
 */
public class SingleStringMapper implements RowMapper<String> {

	/**
	 * This method map the result set to String
	 * @param rs object of ResultSet
	 * @param rowNum int represent total row in result set
	 * @return String
	 */
	@Override
	public String mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		return rs.getString(1);
	}
	
}
