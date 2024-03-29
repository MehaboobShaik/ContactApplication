package com.myproject.util;

public class StringUtility {

	/*
	 * this method
	 */
	public static String  toCommaSeperatedString( Object[] items) {
		
		StringBuilder builder = new StringBuilder();
		for(Object item : items) {
			builder.append(item).append(",");
		}
		if(builder.length()>0) {
			builder.deleteCharAt(builder.length()-1);
		}
		
		return builder.toString();
		
	}
}
