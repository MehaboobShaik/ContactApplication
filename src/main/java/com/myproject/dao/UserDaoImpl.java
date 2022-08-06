package com.myproject.dao;

import java.util.*;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.myproject.domain.User;
import com.myproject.rm.UserRowMapper;

@Repository
public class UserDaoImpl extends BaseDao implements IUserDao {
	
	@Override
	public void save(User u) {
		String sql ="Insert into user(name,phone,address,email,loginName,password,loginStatus,role)"
				  +"values(:name, :phone, :email, :address, :loginName, :password, :loginStatus, :role)";
		 
		 Map<String, Comparable> map = new HashMap<String, Comparable>();
         map.put("name", u.getName());
         map.put("phone", u.getPhone());
         map.put("email", u.getEmail());
         map.put("address", u.getAddress());
         map.put("loginName", u.getLoginName());
         map.put("password", u.getPassword());
         map.put("loginStatus", u.getLoginStatus());
         map.put("role", u.getRole());
         //note:It will bind the autogeneraqted key value by database to the query
         KeyHolder keyHolder = new GeneratedKeyHolder();
         //note it supplies the map peramaters to the source param(named params)
         SqlParameterSource sqlPerameterSource = new MapSqlParameterSource(map);
         super.getNamedParameterJdbcTemplate().update(sql, sqlPerameterSource,keyHolder);
         int userId = keyHolder.getKey().intValue();
         u.setUserId(userId);
	}

	@Override
	public void Update(User u) {
		String UpdateSql ="Update user set phone = :phone where userId =:userId";
		 Map<String, Comparable> map = new HashMap<String, Comparable>();
		 map.put("phone", u.getPhone());
         map.put("userId", u.getUserId());
         getNamedParameterJdbcTemplate().update(UpdateSql, map);

	}

	@Override
	public void delete(User u) {
		
		this.delete(u.getUserId());

	}

	@Override
	public void delete(Integer userId) {
		String deleteSql ="delete from user where userId = ?";
		getJdbcTemplate().update(deleteSql,userId);

	}

	@Override
	public User findById(Integer userId) {
		// TODO Auto-generated method stub
        String selectSql ="select userId,name,phone,email,address,loginName,role,loginStatus"+" from user where userId =?";
		User user = getJdbcTemplate().queryForObject(selectSql, new UserRowMapper(),userId);
		return user;
	}
	/*
	 * RowMapper --> it maps a record from resultSet to Domain Object
	 * 1 record  --> 1 domain object
	 */

	@Override
	public List<User> findAll() {
		String selectSqlOne ="select userId,name,phone,email,address,loginName,role,loginStatus"+" from user";
		  return (List<User>) getJdbcTemplate().query(selectSqlOne, new UserRowMapper());
	}

	@Override
	public List<User> findByProperty(String PropName, Object PropValue) {
		  String selectSqlPropery ="select userId,name,phone,email,address,loginName,role,loginStatus"+" from user where "+PropName+"=?";
		  return (List<User>) getJdbcTemplate().query(selectSqlPropery, new UserRowMapper(),PropValue);

	}

}
