package com.inovatex.vendor.exceptions;

@SuppressWarnings("serial")
public class VendorWrongPasswordException extends Exception{
	public VendorWrongPasswordException() {
		super("Vendor Password not match...");
	}

}
