package com.inovatex.admin.exceptions;

@SuppressWarnings("serial")
public class AdminWrongPasswordException extends Exception{
	public AdminWrongPasswordException() {
		super("Admin Password not match...");
	}

}
