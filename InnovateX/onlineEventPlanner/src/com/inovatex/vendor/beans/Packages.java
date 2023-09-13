package com.inovatex.vendor.beans;

import java.util.Objects;



public class Packages {
	private int PackageID;
	private String TypeOfEvent;
	private String PackageType;
	private double decoration;
	private double photography;
	private double catering_veg;
	private double catering_nonveg;
	private String otherservice;
	private int VendorID;

	public double getDecoration() {
		return decoration;
	}
	public void setDecoration(double decoration) {
		this.decoration = decoration;
	}
	public double getPhotography() {
		return photography;
	}
	public void setPhotography(double photography) {
		this.photography = photography;
	}
	public double getCatering_veg() {
		return catering_veg;
	}
	public void setCatering_veg(double catering_veg) {
		this.catering_veg = catering_veg;
	}
	public double getCatering_nonveg() {
		return catering_nonveg;
	}
	public void setCatering_nonveg(double catering_nonveg) {
		this.catering_nonveg = catering_nonveg;
	}
	public String getOtherservice() {
		return otherservice;
	}
	public void setOtherservice(String otherservice) {
		this.otherservice = otherservice;
	}
	public int getPackageID() {
        return PackageID;
    }
    public void setPackageID(int packageID) {
        PackageID = packageID;
    }
    public String getTypeOfEvent() {
        return TypeOfEvent;
    }
    public void setTypeOfEvent(String typeOfEvent) {
        TypeOfEvent = typeOfEvent;
    }
    public String getPackageType() {
        return PackageType;
    }
    public void setPackageType(String packageType) {
        PackageType = packageType;
    }
    public int getVendorID() {
        return VendorID;
    }
    public void setVendorID(int vendorID) {
        VendorID = vendorID;
    }
    
	public Packages() {
		
	}
	@Override
	public int hashCode() {
		return Objects.hash(PackageID, PackageType, TypeOfEvent, VendorID, catering_nonveg, catering_veg, decoration,
				otherservice, photography);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Packages other = (Packages) obj;
		return PackageID == other.PackageID && Objects.equals(PackageType, other.PackageType)
				&& Objects.equals(TypeOfEvent, other.TypeOfEvent) && VendorID == other.VendorID
				&& Double.doubleToLongBits(catering_nonveg) == Double.doubleToLongBits(other.catering_nonveg)
				&& Double.doubleToLongBits(catering_veg) == Double.doubleToLongBits(other.catering_veg)
				&& Double.doubleToLongBits(decoration) == Double.doubleToLongBits(other.decoration)
				&& Objects.equals(otherservice, other.otherservice)
				&& Double.doubleToLongBits(photography) == Double.doubleToLongBits(other.photography);
	}
	
	
    

}