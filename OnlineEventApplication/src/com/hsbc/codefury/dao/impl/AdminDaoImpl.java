package com.hsbc.codefury.dao.impl;
import com.hsbc.codefdury.beans.Vendor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import com.hsbc.codefury.dao.AdminDao;
import com.hsbc.codefury.exceptions.VendorAlreadyExistsException;
import com.hsbc.codefury.utils.DBConnection;

//import com.hsbc.employee.utils.DBConnection;

public class AdminDaoImpl implements AdminDao {
	
	Connection conn;
	PreparedStatement pst;
	ResultSet rs;
	

	@Override
	public int addVendor(Vendor vendor)throws VendorAlreadyExistsException {
		
		String addqry = "insert into vendor(VendorName, VendorAddress, VendorEmail, VendorContactNumbers) values(?,?,?,?)";
		//String search = "select code from vendor where VendorContactNumbers=?";
		int rows=0;
		conn = DBConnection.getConnection();
		try {
			
			pst = conn.prepareStatement(addqry);
	
			pst.setString(1, vendor.getVendorName());
			pst.setString(2, vendor.getVendorEmail());
			pst.setString(3, vendor.getVendorAddress()); 
			pst.setString(4, vendor.getVendorContactnumbers()); 
			
			rows = pst.executeUpdate();
			
		}
		catch (SQLIntegrityConstraintViolationException e) {
			throw new VendorAlreadyExistsException();
		}
		
		catch (SQLException e) {
			e.printStackTrace();
			
		}
		DBConnection.close();
		
		return rows;
	}

	@Override
	public List<Vendor> viewVendors() {
		String selectqry = "select * from vendor";
		List<Vendor> vendorlist = new ArrayList<>();
		conn = DBConnection.getConnection();
		try {
			pst = conn.prepareStatement(selectqry);
			rs = pst.executeQuery();
			while(rs.next()) {
				Vendor vndr = new Vendor();
				vndr.setVendorId(rs.getInt(1));
				vndr.setVendorName(rs.getString(2));
				vndr.setVendorAddress(rs.getString(3));
				vndr.setVendorEmail(rs.getString(4));
				vndr.setVendorContactnumbers(rs.getString(5));
				vendorlist.add(vndr);
			}
		} catch (SQLException e) {
				e.printStackTrace();
		}
		return vendorlist;
		
	}

	@Override
	public List<User> viewUsers() throws UserNotFoundException {
		
	}
	

}
