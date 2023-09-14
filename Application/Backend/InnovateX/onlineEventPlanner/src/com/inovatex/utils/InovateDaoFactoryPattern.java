package com.inovatex.utils;

import com.inovatex.admin.service.AdminService;
import com.inovatex.admin.service.AdminServiceImpl;
import com.inovatex.user.service.UserService;
import com.inovatex.user.service.UserServiceImpl;
import com.inovatex.vendor.service.VendorService;
import com.inovatex.vendor.service.VendorServiceImpl;

public class InovateDaoFactoryPattern {
	
	public UserService getUserServiceImpl() {
		return new UserServiceImpl();
	}
	public AdminService getAdminServiceImpl() {
		return new AdminServiceImpl();
	}
	public VendorService getVendorServiceImpl() {
		return new VendorServiceImpl();
	}

}
