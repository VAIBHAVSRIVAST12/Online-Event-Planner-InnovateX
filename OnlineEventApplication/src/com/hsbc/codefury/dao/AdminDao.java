package com.hsbc.codefury.dao;

import java.util.List;

import com.hsbc.codefdury.beans.Users;
import com.hsbc.codefdury.beans.Vendor;
import com.hsbc.codefury.exceptions.UserNotFoundException;
import com.hsbc.codefury.exceptions.VendorAlreadyExistsException;
import com.hsbc.codefury.exceptions.VendorNotFoundException;
public interface AdminDao {
	public int addVendor(Vendor vendor)throws VendorAlreadyExistsException;
	public List<Vendor> viewVendors() throws VendorNotFoundException;
	public List<Users> viewUsers() throws UserNotFoundException;
	public String activateDeactivate(int userid);


}
