package com.hsbc.codefdury.beans;

import java.util.Objects;

public class Vendor {
	private int vendorId;
	private String vendorName;
	private String vendorAddress;
	private String vendorEmail;
	private String vendorContactnumbers;
	@Override
	public int hashCode() {
		return Objects.hash(vendorAddress, vendorContactnumbers, vendorEmail, vendorId, vendorName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vendor other = (Vendor) obj;
		return Objects.equals(vendorAddress, other.vendorAddress)
				&& Objects.equals(vendorContactnumbers, other.vendorContactnumbers)
				&& Objects.equals(vendorEmail, other.vendorEmail) && vendorId == other.vendorId
				&& Objects.equals(vendorName, other.vendorName);
	}
	public int getVendorId() {
		return vendorId;
	}
	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getVendorAddress() {
		return vendorAddress;
	}
	public void setVendorAddress(String vendorAddress) {
		this.vendorAddress = vendorAddress;
	}
	public String getVendorEmail() {
		return vendorEmail;
	}
	public void setVendorEmail(String vendorEmail) {
		this.vendorEmail = vendorEmail;
	}
	public String getVendorContactnumbers() {
		return vendorContactnumbers;
	}
	public void setVendorContactnumbers(String vendorContactnumbers) {
		this.vendorContactnumbers = vendorContactnumbers;
	}

}
