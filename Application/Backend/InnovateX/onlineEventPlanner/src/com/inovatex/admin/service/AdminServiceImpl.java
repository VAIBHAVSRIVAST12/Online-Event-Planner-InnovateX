package com.inovatex.admin.service;

import java.util.List;
import com.inovatex.admin.beans.Admin;
import com.inovatex.admin.beans.Vendor;
import com.inovatex.admin.dao.AdminDao;
import com.inovatex.admin.dao.AdminDaoImpl;
import com.inovatex.admin.exceptions.AdminNotFoundExceptions;
import com.inovatex.admin.exceptions.AdminWrongPasswordException;
import com.inovatex.admin.exceptions.VendorAlreadyExistsException;
import com.inovatex.admin.exceptions.VendorNotFoundException;
import com.inovatex.user.beans.User;
import com.inovatex.user.exceptions.UserNotFoundExceptions;

public class AdminServiceImpl implements AdminService {
	AdminDao adminDao = new AdminDaoImpl();

	@Override
	public Admin getAdminByAdminUsername(String adminUsername) throws AdminNotFoundExceptions {
		return adminDao.getAdminByAdminUsername(adminUsername);
	}

	@Override
	public boolean validateAdmin(String adminUsername, String adminPassword)
			throws AdminNotFoundExceptions, AdminWrongPasswordException {
		try {
			Admin admin = getAdminByAdminUsername(adminUsername);
			if(admin.getAdminPassword().equals(adminPassword)) {
				return true;
			}
			else {
				throw new AdminWrongPasswordException();
			}
		} catch (AdminNotFoundExceptions e) {
			throw new AdminNotFoundExceptions();
		}

	}

	@Override
	public int addVendor(Vendor vendor) throws VendorAlreadyExistsException {
		
		return adminDao.addVendor(vendor);
	}

	@Override
	public List<Vendor> viewVendors() throws VendorNotFoundException {
		
		return adminDao.viewVendors();
	}

	@Override
	public List<User> allUser() throws UserNotFoundExceptions {
		
		return adminDao.allUser();
	}

	@Override
	public int changeStatus(int userId, String status) throws UserNotFoundExceptions {
		
		return adminDao.changeStatus(userId, status);
	}

}

	
