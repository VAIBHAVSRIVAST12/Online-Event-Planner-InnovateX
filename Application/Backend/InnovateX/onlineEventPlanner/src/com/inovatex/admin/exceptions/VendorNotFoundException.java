package com.inovatex.admin.exceptions;

@SuppressWarnings("serial")
public class VendorNotFoundException extends Exception {
	public VendorNotFoundException()
	{
		super("vendor not found...");
	}
}
