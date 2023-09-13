package com.inovatex.admin.exceptions;

@SuppressWarnings("serial")
public class VendorAlreadyExistsException extends Exception {
	public VendorAlreadyExistsException()
	{
		super("vendor already exists...");
	}

}
