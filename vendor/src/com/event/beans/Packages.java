package com.event.beans;

public class Packages {
	protected int PackageID;
    public int getPackageID() {
        return PackageID;
    }
    public void setPackageID(int packageID) {
        PackageID = packageID;
    }
    private String TypeOfEvent;
    public String getTypeOfEvent() {
        return TypeOfEvent;
    }
    public void setTypeOfEvent(String typeOfEvent) {
        TypeOfEvent = typeOfEvent;
    }
    private String PackageType;
    public String getPackageType() {
        return PackageType;
    }
    public void setPackageType(String packageType) {
        PackageType = packageType;
    }
    private int VendorID;
    public int getVendorID() {
        return VendorID;
    }
    public void setVendorID(int vendorID) {
        VendorID = vendorID;
    }
    public static int getServiceID() {
		return ServiceID;
	}
	public void setServiceID(int serviceID) {
		ServiceID = serviceID;
	}
	private static int ServiceID;
    

}



