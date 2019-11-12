package com.parkingsystem.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * This is mapper class for Integer
 * @author Rahul
 *
 */
public class SingleIntegerMapper implements RowMapper<Integer>{

	/**
	 * This method map the result set to Integer
	 * @param rs object of ResultSet
	 * @param rowNum int represent total row in result set
	 * @return integer
	 */
	@Override
	public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
		return rs.getInt(1);
	}

}
