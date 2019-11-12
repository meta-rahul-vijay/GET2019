package com.parkingsystem.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.parkingsystem.model.dto.FriendDTO;

/**
 * This is FriendDTO class Mapper
 * @author Rahul
 *
 */
public class FriendMapper implements RowMapper<FriendDTO> {

	/**
	 * This method map the result set to FriendDTO object
	 * @param rs object of ResultSet
	 * @param rowNum int represent total row in result set
	 * @return object of FriendDTO
	 */
	@Override
	public FriendDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		FriendDTO friendDTO = new FriendDTO();
		friendDTO.setId(rs.getInt(1));
		friendDTO.setName(rs.getString(2));
		friendDTO.setGender(rs.getString(3));
		friendDTO.setEmail(rs.getString(4));
		friendDTO.setPhoneNumber(rs.getString(5));
		friendDTO.setCompany(rs.getString(6));
		return friendDTO;
	}

}
