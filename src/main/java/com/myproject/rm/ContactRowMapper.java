package com.myproject.rm;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.myproject.domain.Contact;
import com.myproject.domain.User;

public class ContactRowMapper implements RowMapper<Contact>{

	/*
	 * RowMapper --> it maps a record from resultSet to Domain Object
	 * 1 record  --> 1 domain object
	 */
	@Override
	public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
		Contact contact = new Contact();
		contact.setContactId(rs.getInt("contactId"));
		contact.setUserId(rs.getInt("userid"));
		contact.setName(rs.getString("name"));
		contact.setEmail(rs.getString("email"));
		contact.setAddress(rs.getString("address"));
		contact.setPhone(rs.getString("phone"));
		contact.setRemark(rs.getString("remark"));
		return contact;
	}

}
