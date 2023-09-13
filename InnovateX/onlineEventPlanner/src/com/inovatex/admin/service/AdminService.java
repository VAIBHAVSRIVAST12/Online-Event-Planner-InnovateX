package com.inovatex.admin.service;

import java.util.List;

import com.inovatex.admin.beans.Admin;
import com.inovatex.admin.beans.Vendor;
import com.inovatex.admin.exceptions.AdminNotFoundExceptions;
import com.inovatex.admin.exceptions.AdminWrongPasswordException;
import com.inovatex.admin.exceptions.VendorAlreadyExistsException;
import com.inovatex.admin.exceptions.VendorNotFoundException;
import com.inovatex.user.beans.User;
import com.inovatex.user.exceptions.UserNotFoundExceptions;
import com.inovatex.user.exceptions.UserWrongPasswordException;

public interface AdminService {
	public int addVendor(Vendor vendor)throws VendorAlreadyExistsException;
	Admin getAdminByAdminUsername(String adminUsername) throws AdminNotFoundExceptions ;
	boolean validateAdmin(String adminUsername,String adminPassword) throws AdminNotFoundExceptions, AdminWrongPasswordException;
	public List<Vendor> viewVendors() throws VendorNotFoundException;
	List<User> allUser()throws UserNotFoundExceptions;
	int changeStatus(int userId, String status) throws UserNotFoundExceptions;
}
