package com.hsbc.codefury.exceptions;

@SuppressWarnings("serial")
public class UserNotFoundException extends Exception {
	public UserNotFoundException()
	{
		super("user not found...");
	}

}
