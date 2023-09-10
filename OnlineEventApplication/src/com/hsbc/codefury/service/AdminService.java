package com.hsbc.codefury.service;

import java.util.List;

import com.hsbc.codefdury.beans.Vendor;
//import com.hsbc.employee.beans.Employee;
import com.hsbc.codefury.exceptions.VendorAlreadyExistsException;

public interface AdminService {
	public int addVendor(Vendor vendor)throws VendorAlreadyExistsException;
	public List<Vendor> viewVendors();
	public List<User> viewUsers()throws UserNotFoundException;

}
