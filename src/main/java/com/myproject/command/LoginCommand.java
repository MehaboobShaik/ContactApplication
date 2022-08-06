package com.myproject.command;

/*
 *  controller --->command --->[(form) view] while form edit view
 *   and vice - versa(while submitting the form to save/update).
 */
public class LoginCommand {

	private String loginName;
	private String password;
	
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    	
}
