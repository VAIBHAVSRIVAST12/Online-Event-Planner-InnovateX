package com.hsbc.codefury.dao;

import java.util.List;

import com.hsbc.codefdury.beans.Vendor;
import com.hsbc.codefury.exceptions.VendorAlreadyExistsException;
public interface AdminDao {
	public int addVendor(Vendor vendor)throws VendorAlreadyExistsException;
	public List<Vendor> viewVendors();
	public List<User> viewUsers()throws UserNotFoundException;


}
