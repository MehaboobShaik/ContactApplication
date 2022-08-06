package com.myproject.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.myproject.domain.Contact;
import com.myproject.rm.ContactRowMapper;

@Repository
public class ContactDaoImpl extends BaseDao implements IContactDao {

	@Override
	public void save(Contact c) {

		String insertQuery = "insert into contact(UserId, name, phone, email, address, remark)"
				+ "values(:UserId,:name,:phone,:email,:address,:remark)";
		Map<String, Comparable> map = new HashMap<String, Comparable>();
		map.put("UserId", c.getUserId());
		map.put("name", c.getName());
		map.put("phone", c.getPhone());
		map.put("email", c.getEmail());
		map.put("address", c.getAddress());
		map.put("remark", c.getRemark());
		KeyHolder keyHolder = new GeneratedKeyHolder();
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource(map);
		super.getNamedParameterJdbcTemplate().update(insertQuery, mapSqlParameterSource, keyHolder);
		int contactId = keyHolder.getKey().intValue();
		c.setContactId(contactId);
	}

	@Override
	public void Update(Contact c) {

		String UpdateQuery = "update  contact set userId = :userId, name = :name, phone = :phone, email = :email, address = :address,remark = :remark where contactId=:contactId";
		Map<String, Comparable> map = new HashMap<String, Comparable>();
		map.put("userId", c.getUserId());
		map.put("name", c.getName());
		map.put("phone", c.getPhone());
		map.put("email", c.getEmail());
		map.put("address", c.getAddress());
		map.put("remark", c.getRemark());
		map.put("contactId", c.getContactId());
		super.getNamedParameterJdbcTemplate().update(UpdateQuery, map);

	}

	@Override
	public void delete(Contact c) {

		this.delete(c.getContactId());

	}

	@Override
	public void delete(Integer contactId) {
		String DeleteQuery = "delete from contact where contactId =? ";
		getJdbcTemplate().update(DeleteQuery, contactId);

	}

	@Override
	public Contact findById(Integer contactId) {

		String selectQuery = "select contactId,UserId, name, phone, email, address, remark from contact where contactId =?";
		return getJdbcTemplate().queryForObject(selectQuery, new ContactRowMapper(), contactId);
	}

	@Override
	public List<Contact> findAll() {

		String selectSqlQuery = "select * from contact";
		List<Contact> query = getJdbcTemplate().query(selectSqlQuery, new ContactRowMapper());
		return query;
	}

	@Override
	public List<Contact> findByProperty(String PropName, Object PropValue) {
		String selectSqlPropery = "select ContactId,userId,name,phone,email,address,remark" + " from contact where "
				+ PropName + "=?";
		return (List<Contact>) getJdbcTemplate().query(selectSqlPropery, new ContactRowMapper(), PropValue);
	}

}
