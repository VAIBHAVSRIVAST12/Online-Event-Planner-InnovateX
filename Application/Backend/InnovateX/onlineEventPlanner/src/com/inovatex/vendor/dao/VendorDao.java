package com.inovatex.vendor.dao;

import java.util.List;

import com.inovatex.admin.beans.Vendor;
import com.inovatex.admin.exceptions.VendorNotFoundException;
import com.inovatex.user.beans.PlanRequest;
import com.inovatex.user.exceptions.PlanRequestNotFoundExceptions;
import com.inovatex.user.exceptions.UserNotFoundExceptions;
import com.inovatex.vendor.beans.Packages;
import com.inovatex.vendor.beans.Quotation;
import com.inovatex.vendor.exceptions.PackageAlreadyExistsException;
import com.inovatex.vendor.exceptions.PackageNotFoundExceptions;
import com.inovatex.vendor.exceptions.QuotationAlreadyExistsException;
import com.inovatex.vendor.exceptions.QuotationNotFoundExceptions;

public interface VendorDao {
	
	int addPackage(Packages packages) throws PackageAlreadyExistsException;
	List<Packages> viewPackages(int vendorId)throws PackageNotFoundExceptions;
	Vendor getVendorByVendorId(int vendorID)throws VendorNotFoundException;
	List<PlanRequest> allRequest()throws PlanRequestNotFoundExceptions;
	int changePassword(int vendorId,String password) throws VendorNotFoundException;
	int createQuoation(Quotation quotation)throws QuotationAlreadyExistsException;
	List<Quotation> viewQuotation(int userId)throws QuotationNotFoundExceptions;
	List<Quotation> viewQuotationForVendor(int vendorId)throws QuotationNotFoundExceptions;
	PlanRequest getPlanRequest(int requestId)throws PlanRequestNotFoundExceptions;
	Packages getPackage(int vendorId,String packageType)throws PackageNotFoundExceptions;
	int getUserIdByPlanRequestId(int planRequestId)throws UserNotFoundExceptions;
	Quotation getQuotationByQuotationId(int quotationId)throws QuotationNotFoundExceptions;
	int selectQuotation(int quotationId, String QuotationStatus) throws QuotationNotFoundExceptions;
	int setSelectQuotationId(String username, int quotationId) throws UserNotFoundExceptions;
}