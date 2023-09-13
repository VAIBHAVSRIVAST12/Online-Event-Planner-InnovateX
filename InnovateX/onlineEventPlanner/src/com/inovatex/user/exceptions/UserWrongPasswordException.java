package com.inovatex.user.exceptions;

@SuppressWarnings("serial")
public class UserWrongPasswordException extends Exception{
	public UserWrongPasswordException() {
		super("User Password not match...");
	}

}
