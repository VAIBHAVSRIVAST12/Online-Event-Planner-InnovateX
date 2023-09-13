package com.inovatex.vendor.exceptions;

@SuppressWarnings("serial")
public class PackageAlreadyExistsException extends Exception{
	public PackageAlreadyExistsException() {
		super("Package already exists...");
	}
}
