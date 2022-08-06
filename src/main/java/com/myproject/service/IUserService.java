package com.myproject.service;

import java.util.List;

import com.myproject.domain.User;
import com.myproject.excpetion.UserBlockedException;

public interface IUserService {
	
	 public static final Integer LOGIN_STATUS_ACTIVE = 1;
	 public static final Integer LOGIN_STATUS_BLOCKED = 2;

	 public static final Integer ROLE_ADMIN = 1;
	 public static final Integer ROLE_USER = 2;
    
	 
	/*
	 * This method handled the user registartion task.
	 */
	public void register(User u);
	/*
	 * @The method handled login operation(authentication)
	 *  using given credentials, it retuens user object when sucess and null when failed.
	 *  when user account bloced an excpetion thrown by this method 
	 *  UserBlockedException this will be thrown when user account blocked
	 * 
	 */
	public User Login(String loginName ,String password) throws UserBlockedException;
	
	/*
	 * Admin can call this method to get the list of the registered users
	 */
	public List<User> getUserList();
	/*
	 * This method change thge user login status based for details passed as args.
	 */
	public void changeLoginStatus(Integer userId, Integer loginStatus);
	
}
