package com.inovatex.admin.dao;
import com.inovatex.admin.beans.Admin;
import com.inovatex.admin.beans.Vendor;
import com.inovatex.admin.exceptions.AdminNotFoundExceptions;
import com.inovatex.admin.exceptions.VendorAlreadyExistsException;
import com.inovatex.admin.exceptions.VendorNotFoundException;
import com.inovatex.user.beans.User;
import com.inovatex.user.exceptions.UserNotFoundExceptions;
import com.inovatex.utils.DBConnections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class AdminDaoImpl implements AdminDao {
	Connection conn;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	
	@Override
	public Admin getAdminByAdminUsername(String adminUsername) throws AdminNotFoundExceptions {
		conn = DBConnections.getConnection();
		String selectquery="select * from admin where adminusername=?";
		try {
			preparedStatement=conn.prepareStatement(selectquery);
			preparedStatement.setString(1, adminUsername);
			resultSet=preparedStatement.executeQuery();
			if(resultSet.next())
			{
				Admin admin = new Admin();
				admin.setAdminId(resultSet.getInt("AdminID"));
				admin.setAdminUsername(resultSet.getString("AdminUsername"));
				admin.setAdminFullname(resultSet.getString("AdminFullName"));
				admin.setAdminEmail(resultSet.getString("AdminEmail"));
				admin.setAdminPassword(resultSet.getString("AdminPassword"));
				admin.setAdminEmail(resultSet.getString("AdminMobile"));
							
				return admin;
						}
			 
			
		} catch (SQLException e) {
			 
		}
		DBConnections.close();
		throw new AdminNotFoundExceptions();
	
	}

	@Override
	public int addVendor(Vendor vendor) throws VendorAlreadyExistsException {
		String addqry = "insert into vendor(VendorName, VendorAddress, VendorEmail, VendorContactNumbers,vendorpassword) values(?,?,?,?,?)";
		int rows=0;
		conn = DBConnections.getConnection();
		try {
			
			preparedStatement = conn.prepareStatement(addqry);
	
			preparedStatement.setString(1, vendor.getVendorName());
			preparedStatement.setString(3, vendor.getVendorEmail());
			preparedStatement.setString(2, vendor.getVendorAddress()); 
			preparedStatement.setString(4, vendor.getVendorContactnumbers()); 
			preparedStatement.setString(5, vendor.getVendorPassword());
			rows = preparedStatement.executeUpdate();
			
		}
		catch (SQLIntegrityConstraintViolationException e) {
			throw new VendorAlreadyExistsException();
		}
		
		catch (SQLException e) {
			 
			
		}
		DBConnections.close();
		
		return rows;
	}

	@Override
	public List<Vendor> viewVendors() throws VendorNotFoundException {
		String selectqry = "select * from vendor";
		List<Vendor> vendorList = new ArrayList<>();
		conn = DBConnections.getConnection();
		try {
			preparedStatement = conn.prepareStatement(selectqry);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Vendor vendor = new Vendor();
				vendor.setVendorId(resultSet.getInt("VendorID"));
				vendor.setVendorName(resultSet.getString("VendorName"));
				vendor.setVendorAddress(resultSet.getString("VendorAddress"));
				vendor.setVendorEmail(resultSet.getString("VendorEmail"));
				vendor.setVendorContactnumbers(resultSet.getString("VendorContactNumbers"));
				vendor.setVendorPassword(resultSet.getString("vendorpassword"));
				vendorList.add(vendor);
			}
			return vendorList;
		} catch (SQLException e) {
				 
		}
		throw new VendorNotFoundException();
		
	}

	@Override
	public List<User> allUser() throws UserNotFoundExceptions {
		String selectquery="select * from user";
		List<User> userList = new ArrayList<>();
		conn=DBConnections.getConnection();
		try {
			preparedStatement=conn.prepareStatement(selectquery);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{			
				User user = new User();
				 user.setUserId(resultSet.getInt("userId"));
                user.setUserFullName(resultSet.getString("userfullName"));
                user.setUsername(resultSet.getString("username"));
                user.setUserPassword(resultSet.getString("userpassword"));
                LocalDate doj = LocalDate.parse(resultSet.getDate("userdateOfJoining").toString(),DateTimeFormatter.ISO_DATE);
                user.setUserDateOfJoining(doj);
                LocalDate dob = LocalDate.parse(resultSet.getDate("userdateOfBirth").toString(),DateTimeFormatter.ISO_DATE);
                user.setUserDateOfBirth(dob);
                user.setUserDepartment(resultSet.getString("userdepartment"));
                user.setUserMobile(resultSet.getString("usermobile"));
                user.setUserEmail(resultSet.getString("useremail"));
                user.setUserLocation(resultSet.getString("userlocation"));
                user.setUserStatus(resultSet.getString("userstatus"));
                user.setQuotationSelectedId(resultSet.getInt("quotationSelectedId"));
                userList.add(user);
			}
			return userList;
		} catch (SQLException e) {
			
		}
		DBConnections.close();
		throw new UserNotFoundExceptions();
	}

	@Override
	public int changeStatus(int userId, String status) throws UserNotFoundExceptions {
		int rows=0;
		 conn = DBConnections.getConnection();
		 String updateSql = "UPDATE user SET userstatus=? WHERE userid=?";
		 try {
				preparedStatement = conn.prepareStatement(updateSql);
				preparedStatement.setString(1, status);
	            preparedStatement.setInt(2, userId);
				rows = preparedStatement.executeUpdate();
				if (rows==0) {
					throw new UserNotFoundExceptions();
				}
		 }catch (SQLException e) {
				
				 
			}
		 DBConnections.close();
		 return rows;
	}

	
	

}
