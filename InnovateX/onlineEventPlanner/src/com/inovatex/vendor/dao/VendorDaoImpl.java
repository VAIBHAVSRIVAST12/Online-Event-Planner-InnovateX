package com.inovatex.vendor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.inovatex.admin.beans.Vendor;
import com.inovatex.admin.exceptions.VendorNotFoundException;
import com.inovatex.user.beans.PlanRequest;
import com.inovatex.user.beans.User;
import com.inovatex.user.exceptions.PlanRequestNotFoundExceptions;
import com.inovatex.user.exceptions.UserNotFoundExceptions;
import com.inovatex.utils.DBConnections;
import com.inovatex.vendor.beans.Packages;
import com.inovatex.vendor.beans.Quotation;
import com.inovatex.vendor.exceptions.PackageAlreadyExistsException;
import com.inovatex.vendor.exceptions.PackageNotFoundExceptions;
import com.inovatex.vendor.exceptions.QuotationAlreadyExistsException;
import com.inovatex.vendor.exceptions.QuotationNotFoundExceptions;

public class VendorDaoImpl implements VendorDao{
	Connection conn;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	@Override
	public Vendor getVendorByVendorId(int vendorID) throws VendorNotFoundException {
		conn = DBConnections.getConnection();
		String selectquery="select * from vendor where vendorid=?";
		try {
			preparedStatement=conn.prepareStatement(selectquery);
			preparedStatement.setInt(1, vendorID);
			resultSet=preparedStatement.executeQuery();
			if(resultSet.next())
			{	
				Vendor vendor = new Vendor();
				vendor.setVendorId(resultSet.getInt("VendorID"));
				vendor.setVendorName(resultSet.getString("VendorName"));
				vendor.setVendorAddress(resultSet.getString("VendorAddress"));
				vendor.setVendorEmail(resultSet.getString("VendorEmail"));
				vendor.setVendorContactnumbers(resultSet.getString("VendorContactNumbers"));
				vendor.setVendorPassword(resultSet.getString("vendorpassword"));
				return vendor;
			}
						
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBConnections.close();
		throw new VendorNotFoundException();
	
	}
	@Override
	public int addPackage(Packages packages) throws PackageAlreadyExistsException {
		conn = DBConnections.getConnection();
		int rows=0;
		String insertsql = "INSERT INTO package ( TypeOfEvent, PackageType,VendorID,Decoration,photography,catering_veg,catering_nonveg,otherservice) VALUES ( ?,?,?,?,?,?,?,?)";
		try {
			preparedStatement = conn.prepareStatement(insertsql);
			preparedStatement.setString(1, packages.getTypeOfEvent());
			preparedStatement.setString(2, packages.getPackageType());
			preparedStatement.setInt(3, packages.getVendorID());
			preparedStatement.setDouble(4, packages.getDecoration());
			preparedStatement.setDouble(5, packages.getPhotography());
			preparedStatement.setDouble(6, packages.getCatering_veg());;
			preparedStatement.setDouble(7, packages.getCatering_nonveg());
			preparedStatement.setString(8, packages.getOtherservice());
			
			rows = preparedStatement.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
			throw new PackageAlreadyExistsException();
        }        
			catch (SQLException e) {
        	e.printStackTrace();
        }
		DBConnections.close();
		return rows;
		
	}
	@Override
	public List<PlanRequest> allRequest() throws PlanRequestNotFoundExceptions {
		String selectquery="select * from planrequest";
		List<PlanRequest> planRequestList = new ArrayList<>();
		conn=DBConnections.getConnection();
		try {
			preparedStatement=conn.prepareStatement(selectquery);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{			
				User user = new User();
				PlanRequest planRequest= new PlanRequest();
				planRequest.setRequestId(resultSet.getInt("RequestID"));
				planRequest.setRequestServicesNeeded(resultSet.getString("RequestServices"));
                LocalDate fromDate = LocalDate.parse(resultSet.getDate("RequestFromDate").toString(),DateTimeFormatter.ISO_DATE);
                planRequest.setRequestFromDate(fromDate);
                user.setUserDateOfJoining(fromDate);
                LocalDate toDate = LocalDate.parse(resultSet.getDate("RequestToDate").toString(),DateTimeFormatter.ISO_DATE);
                planRequest.setRequestToDate(toDate);
                planRequest.setRequestNumberOfPersons(resultSet.getInt("RequestNumberOfPersons"));
                planRequest.setUserId(resultSet.getInt("UserID"));
                planRequestList.add(planRequest);
			}
			return planRequestList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBConnections.close();
		throw new PlanRequestNotFoundExceptions();
	}
	@Override
	public int changePassword(int vendorId, String password) throws VendorNotFoundException {
		int rows=0;
		 conn = DBConnections.getConnection();
		 String updateSql = "UPDATE vendor SET  vendorpassword=? WHERE VendorID=?";
		 try {
				preparedStatement = conn.prepareStatement(updateSql);
				preparedStatement.setString(1, password);
	            preparedStatement.setInt(2, vendorId);
				rows = preparedStatement.executeUpdate();
				if (rows==0) {
					throw new VendorNotFoundException();
				}
		 }catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 DBConnections.close();
		 return rows;
	}
	@Override
	public int createQuoation(Quotation quotation) throws QuotationAlreadyExistsException {
		conn = DBConnections.getConnection();
		int rows=0;
		String insertsql = "insert into quotation (QuotationEstimatedAmount,VendorID,UserID,PlanRequestID,packageid) values (?,?,?,?,?);";
		try {
			preparedStatement = conn.prepareStatement(insertsql);
			preparedStatement.setDouble(1, quotation.getQuotationEstimatedAmount());
			preparedStatement.setInt(2, quotation.getVendorID());
			preparedStatement.setInt(3, quotation.getUserID());
			preparedStatement.setInt(4, quotation.getPlanRequestID());
			
			preparedStatement.setInt(5, quotation.getPackageid());
			
			rows = preparedStatement.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
			throw new QuotationAlreadyExistsException();
        }        
			catch (SQLException e) {
        	e.printStackTrace();
        }
		DBConnections.close();
		return rows;
	}
	@Override
	public PlanRequest getPlanRequest(int requestId) throws PlanRequestNotFoundExceptions {
		conn = DBConnections.getConnection();
		String selectquery="select * from planrequest where RequestID=?";
		try {
			preparedStatement=conn.prepareStatement(selectquery);
			preparedStatement.setInt(1, requestId);
			resultSet=preparedStatement.executeQuery();
			if(resultSet.next())
			{	
				PlanRequest planRequest= new PlanRequest();
				planRequest.setRequestId(resultSet.getInt("RequestID"));
				planRequest.setRequestServicesNeeded(resultSet.getString("RequestServices"));
                LocalDate fromDate = LocalDate.parse(resultSet.getDate("RequestFromDate").toString(),DateTimeFormatter.ISO_DATE);
                planRequest.setRequestFromDate(fromDate);
                LocalDate toDate = LocalDate.parse(resultSet.getDate("RequestToDate").toString(),DateTimeFormatter.ISO_DATE);
                planRequest.setRequestToDate(toDate);
                planRequest.setRequestNumberOfPersons(resultSet.getInt("RequestNumberOfPersons"));
                planRequest.setUserId(resultSet.getInt("UserID"));
				return planRequest;
				
			}
			 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBConnections.close();
		throw new PlanRequestNotFoundExceptions();
	}
	@Override
	public Packages getPackage(int vendorId, String packageType) throws PackageNotFoundExceptions {
		conn = DBConnections.getConnection();
		String selectquery=" select * from package where vendorid=? and packagetype=?;";
		try {
			preparedStatement=conn.prepareStatement(selectquery);
			preparedStatement.setInt(1, vendorId);
			preparedStatement.setString(2, packageType);
			resultSet=preparedStatement.executeQuery();
			if(resultSet.next())
			{	Packages packages = new Packages();
				packages.setPackageID(resultSet.getInt("PackageID"));
				packages.setTypeOfEvent(resultSet.getString("TypeOfEvent"));
				packages.setPackageType(resultSet.getString("PackageType"));
				packages.setVendorID(resultSet.getInt("VendorID"));
				packages.setOtherservice(resultSet.getString("otherservice"));
				packages.setPhotography(resultSet.getDouble("photography"));
				packages.setDecoration(resultSet.getDouble("Decoration"));
				packages.setCatering_veg(resultSet.getDouble("catering_veg"));
				packages.setCatering_nonveg(resultSet.getDouble("catering_nonveg"));
				
				return packages;
				
			}
			 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBConnections.close();
		throw new PackageNotFoundExceptions();
	}
	@Override
	public int getUserIdByPlanRequestId(int planRequestId) throws UserNotFoundExceptions {
		
		String selectquery="select userid from planrequest where requestid=?";
		conn=DBConnections.getConnection();
		int userId;
		try {
			preparedStatement=conn.prepareStatement(selectquery);
			preparedStatement.setInt(1, planRequestId);
			resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				userId=resultSet.getInt("userId");
				return userId;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		throw new UserNotFoundExceptions();
	
	}
	@Override
	public List<Quotation> viewQuotation(String username) throws QuotationNotFoundExceptions {
		String selectquery="select * from Quotation where username=?";
		List<Quotation> quotationList = new ArrayList<>();
		conn=DBConnections.getConnection();
		try {
			preparedStatement=conn.prepareStatement(selectquery);
			preparedStatement.setString(1, username);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{			
				Quotation quotation = new Quotation();
				quotation.setQuotationID(resultSet.getInt("QuotationID"));
				quotation.setVendorID(resultSet.getInt("VendorID"));
				quotation.setUserID(resultSet.getInt("UserID"));
				quotation.setQuotationStatus(resultSet.getString("QuotationStatus"));
				quotation.setPackageid(resultSet.getInt("packageid"));
				quotation.setQuotationEstimatedAmount(resultSet.getDouble("QuotationEstimatedAmount"));
				quotation.setPlanRequestID(resultSet.getInt("PlanRequestID"));
				quotationList.add(quotation);
				
			}
			return quotationList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBConnections.close();
		throw new QuotationNotFoundExceptions();
	}
	@Override
	public Quotation getQuotationByQuotationId(int quotationId) throws QuotationNotFoundExceptions {
		conn = DBConnections.getConnection();
		String selectquery="select * from quotation where quotationid=?";
		try {
			preparedStatement=conn.prepareStatement(selectquery);
			preparedStatement.setInt(1, quotationId);
			resultSet=preparedStatement.executeQuery();
			if(resultSet.next())
			{	
				Quotation quotation = new Quotation();
				quotation.setQuotationID(resultSet.getInt("QuotationID"));
				quotation.setVendorID(resultSet.getInt("VendorID"));
				quotation.setUserID(resultSet.getInt("UserID"));
				quotation.setQuotationStatus(resultSet.getString("QuotationStatus"));
				quotation.setPackageid(resultSet.getInt("packageid"));
				quotation.setQuotationEstimatedAmount(resultSet.getDouble("QuotationEstimatedAmount"));
				quotation.setPlanRequestID(resultSet.getInt("PlanRequestID"));
				return quotation;
			}
						
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DBConnections.close();
		throw new QuotationNotFoundExceptions();
	
	}
	@Override
	public int selectQuotation(int quotationId, String QuotationStatus) throws QuotationNotFoundExceptions {
		int rows=0;
		 conn = DBConnections.getConnection();
		 String updateSql = "UPDATE quotation SET QuotationStatus=? WHERE quotationid=?";
		 try {
				preparedStatement = conn.prepareStatement(updateSql);
				preparedStatement.setString(1, QuotationStatus);
	            preparedStatement.setInt(2, quotationId);
				rows = preparedStatement.executeUpdate();
				if (rows==0) {
					throw new QuotationNotFoundExceptions();
				}
		 }catch (SQLException e) {
				e.printStackTrace();
			}
		 DBConnections.close();
		 return rows;
	}
	@Override
	public int setSelectQuotationId(String username, int quotationId) throws UserNotFoundExceptions {
		
		int rows=0;
		 conn = DBConnections.getConnection();
		 String updateSql = "UPDATE user SET quotationSelectedId=? WHERE username=?";
		 try {
				preparedStatement = conn.prepareStatement(updateSql);
				preparedStatement.setInt(1, quotationId);
	            preparedStatement.setString(2, username);
				rows = preparedStatement.executeUpdate();
				if (rows==0) {
					throw new UserNotFoundExceptions();
				}
		 }catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 DBConnections.close();
		 return rows;
	}
	

}
