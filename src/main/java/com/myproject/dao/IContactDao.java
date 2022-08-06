package com.myproject.dao;

import java.util.List;

import com.myproject.domain.Contact;
 
public interface IContactDao {

	public void save(Contact u);

	public void Update(Contact u);

	public void delete(Contact u);

	public void delete(Integer contactId);

	public Contact findById(Integer contactId);

	public List<Contact> findAll();
	
	public List<Contact>  findByProperty(String PropName, Object PropValue);
}
