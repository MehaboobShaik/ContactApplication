package com.myproject.service;

import java.util.List;

import com.myproject.domain.Contact;

public interface IContactService {

	public void save(Contact contact);
	public void updtae(Contact contact);
	public void delete(Integer contactId);
	public void delete(Integer[] contactIds);
	
	/*
	 * this methods return all contacts of the user(who is logged in); 
	 */
    public List<Contact> findUserContact(Integer userId);
    /*
	 * this methods serach contacts fou user based on given(userid) and free txt criteria(txt);
	 * txt == criteria used to serach -free text searxh criteria 
	 */
    public List<Contact> findUserContact(Integer userId, String txt);

}
