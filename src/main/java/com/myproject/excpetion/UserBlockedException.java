package com.myproject.excpetion;

public class UserBlockedException extends Exception {

	/*
	 * creates user object without error description
	 */
	public UserBlockedException() {
		
	}

	/*
	 * creates user object with error description
	 */
	public UserBlockedException(String errDesc) {
	super(errDesc);
	}
}
