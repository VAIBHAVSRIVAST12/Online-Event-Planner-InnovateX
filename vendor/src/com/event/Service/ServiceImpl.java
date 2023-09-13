package com.event.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.event.beans.Packages;
import com.event.beans.Quotation;
import com.event.utils.DBConnections;

public class ServiceImpl implements Service{
	Connection conn;
	PreparedStatement preparedStatement;
	ResultSet resultSet;

	@Override
	public int estimatedAmount(int USERID,int ServiceID) {
		conn = DBConnections.getConnection();
		int amount=0;
		int days=0;
		String query2="SELECT RequestFromDate,RequestToDate FROM planrequest where USERID=?;";
		String query1="SELECT  Amount FROM servicelist where ServiceID=?;";
		try {
			preparedStatement=conn.prepareStatement(query1);
			preparedStatement.setInt(1,ServiceID);
			resultSet=preparedStatement.executeQuery();
			PreparedStatement preparedStatement1 = conn.prepareStatement(query2);
			preparedStatement1.setInt(1,USERID);
			ResultSet resultSet1 = preparedStatement1.executeQuery();
			//resultset1 contains from and to dates and resultset contains amount
			//estamount=days*amount
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		// TODO Auto-generated method stub
		return amount;
	}
}
