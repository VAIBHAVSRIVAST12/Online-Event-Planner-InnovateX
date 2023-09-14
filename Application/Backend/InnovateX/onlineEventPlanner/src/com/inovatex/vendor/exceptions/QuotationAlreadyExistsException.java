package com.inovatex.vendor.exceptions;

@SuppressWarnings("serial")
public class QuotationAlreadyExistsException extends Exception{
	public QuotationAlreadyExistsException() {
		super("Quotation already exists...");
	}
}
