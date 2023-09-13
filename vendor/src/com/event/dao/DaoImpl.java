package com.event.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.event.beans.Packages;
import com.event.beans.Quotation;
import com.event.utils.DBConnections;

public class DaoImpl implements Dao{
	Connection conn;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	@Override
	public int addPackage(Packages p) {
		conn = DBConnections.getConnection();
		int rows=0;
		String insertsql = "INSERT INTO package (PackageID, TypeOfEvent, PackageType,VendorID,ServiceID) VALUES (?, ?, ?, ?, ?,?)";
		try {
			preparedStatement = conn.prepareStatement(insertsql);
			preparedStatement.setInt(1, p.getPackageID());
            preparedStatement.setString(2, p.getTypeOfEvent());
            preparedStatement.setString(3, p.getPackageType()); 
            preparedStatement.setInt(4, p.getVendorID());
            preparedStatement.setInt(5, p.getServiceID());
			rows = preparedStatement.executeUpdate();
        } catch (SQLException e) {
        	e.printStackTrace();
        }
		DBConnections.close();
		return rows;
	}
	@Override
	public int createQuoation(Quotation q) {
		conn=DBConnections.getConnection();
		int rows1=0;
		String insertsql = "INSERT INTO quotation (QuotationID,QuotationPackageType,QuotationEstimatedAmount,VendorID,UserID,PlanRequestID) VALUES (?, ?, ?, ?, ?, ?)";
		try {
			preparedStatement = conn.prepareStatement(insertsql);
			preparedStatement.setInt(1, q.getQuotationID());
            preparedStatement.setString(2, q.getQuotationPackageType());
            preparedStatement.setDouble(3, q.getQuotationEstimatedAmount()); 
            preparedStatement.setInt(4, q.getVendorID()); 
            preparedStatement.setInt(5, q.getUserID());
            preparedStatement.setInt(6,q.getPlanRequestID());
            
			rows1 = preparedStatement.executeUpdate();
        } catch (SQLException e) {
        	e.printStackTrace();
        }
		DBConnections.close();
		return rows1;
	}
	@Override
	public void getPackages() {
		
		// TODO Auto-generated method stub
		
	}
	
}
