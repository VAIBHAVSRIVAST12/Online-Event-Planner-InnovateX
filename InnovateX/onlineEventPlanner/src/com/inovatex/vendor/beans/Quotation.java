package com.inovatex.vendor.beans;

import java.util.Objects;

public class Quotation {
	@Override
	public String toString() {
		return "Quotation [quotationID=" + quotationID + ", quotationEstimatedAmount=" + quotationEstimatedAmount
				+ ", vendorID=" + vendorID + ", userID=" + userID + ", planRequestID=" + planRequestID
				+ ", quotationStatus=" + quotationStatus + ", packageid=" + packageid + "]";
	}

	private int quotationID;
	private double quotationEstimatedAmount;
	private int vendorID;
    private  int userID;
    private int planRequestID;
    private String quotationStatus;
    private int packageid;
	public int getQuotationID() {
		return quotationID;
	}
	public void setQuotationID(int quotationID) {
		this.quotationID = quotationID;
	}
	public double getQuotationEstimatedAmount() {
		return quotationEstimatedAmount;
	}
	public void setQuotationEstimatedAmount(double quotationEstimatedAmount) {
		this.quotationEstimatedAmount = quotationEstimatedAmount;
	}
	public int getVendorID() {
		return vendorID;
	}
	public void setVendorID(int vendorID) {
		this.vendorID = vendorID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getPlanRequestID() {
		return planRequestID;
	}
	public void setPlanRequestID(int planRequestID) {
		this.planRequestID = planRequestID;
	}
	public String getQuotationStatus() {
		return quotationStatus;
	}
	public void setQuotationStatus(String quotationStatus) {
		this.quotationStatus = quotationStatus;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(packageid, planRequestID, quotationEstimatedAmount, quotationID, quotationStatus, userID,
				vendorID);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Quotation other = (Quotation) obj;
		return packageid == other.packageid && planRequestID == other.planRequestID
				&& Double.doubleToLongBits(quotationEstimatedAmount) == Double
						.doubleToLongBits(other.quotationEstimatedAmount)
				&& quotationID == other.quotationID && Objects.equals(quotationStatus, other.quotationStatus)
				&& userID == other.userID && vendorID == other.vendorID;
	}
	public int getPackageid() {
		return packageid;
	}
	public void setPackageid(int packageid) {
		this.packageid = packageid;
	}
	
	public Quotation() {
		
	}
	
}
