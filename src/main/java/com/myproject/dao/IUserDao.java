package com.myproject.dao;

import java.util.List;

import com.myproject.domain.User;

public interface IUserDao {

	public void save(User u);

	public void Update(User u);

	public void delete(User u);

	public void delete(Integer userId);

	public User findById(Integer userId);

	public List<User> findAll();
	
	public List<User>  findByProperty(String PropName, Object PropValue);
	

}
