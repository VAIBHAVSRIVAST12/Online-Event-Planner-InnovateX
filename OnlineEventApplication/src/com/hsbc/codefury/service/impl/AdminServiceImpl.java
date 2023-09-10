package com.hsbc.codefury.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.hsbc.codefury.dao.AdminDao;
import com.hsbc.codefury.dao.impl.AdminDaoImpl;
import com.hsbc.codefury.exceptions.VendorAlreadyExistsException;
import com.hsbc.codefury.service.AdminService;
import com.hsbc.codefury.service.User;
import com.hsbc.codefury.service.UserNotFoundException;
import com.hsbc.codefury.service.VendorsNotFoundException;
import com.hsbc.codefury.utils.DBConnection;
import com.hsbc.codefdury.beans.Vendor;

public class AdminServiceImpl implements AdminService {
	AdminDao dao=new AdminDaoImpl();

	@Override
	public int addVendor(Vendor vendor)throws VendorAlreadyExistsException {
		// TODO Auto-generated method stub
		return dao.addVendor(vendor);
	}

	@Override
	public List<Vendor> viewVendors() {
		
		return dao.viewVendors();
	}

	@Override
	public List<User> viewUsers() throws UserNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	//@Override
/*	public List<Vendor> viewVendors() throws VendorsNotFoundException {
		// TODO Auto-generated method stub
		return dao.viewVendors();
	}*/

	//@Override
/*	public List<User> viewUsers() UserNotFoundException {
		// TODO Auto-generated method stub
		return dao.viewUsers();
	}*/

	

	

}

	
