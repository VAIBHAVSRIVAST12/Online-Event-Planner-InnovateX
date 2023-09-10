package com.hsbc.codefury.ui;

import java.util.List;
import java.util.Scanner;

import com.hsbc.codefdury.beans.Vendor;
import com.hsbc.codefury.exceptions.VendorAlreadyExistsException;
import com.hsbc.codefury.service.impl.AdminServiceImpl;
import com.hsbc.employee.beans.Employee;




public class AdminApplication {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AdminServiceImpl service = new AdminServiceImpl();
		
		int choice=0;
		while(choice!=3) {
			System.out.println("1. Add Vendor");
			System.out.println("2. View Vendor");
			System.out.println("3. View User Registrations");
			choice = sc.nextInt();
			switch(choice)
			{
			case 1:
			{
				Vendor vendors=new Vendor();
				String name=sc.next();
				String address=sc.next();
				String email=sc.next();
				String contactNumbers=sc.next();
				//String address=sc.next();
				vendors.setVendorAddress(address);
				vendors.setVendorEmail(email);
				vendors.setVendorName(name);
				vendors.setVendorContactnumbers(contactNumbers);
				try {
					int rows=service.addVendor(vendors);
					if(rows>0)
						System.out.println("inserted");
					else
						System.out.println("not-inserted");
				} catch (VendorAlreadyExistsException v) {
					System.err.println(v.getMessage());
				}
				break;
				}
			case 2:
			{
				List<Vendor> list=service.viewVendors();
				for(Vendor vndr:list)
					System.out.println(vndr.getVendorId()+vndr.getVendorName()+vndr.getVendorAddress()+vndr.getVendorEmail()+vndr.getVendorContactnumbers());
				break;
			}
				
			}
			}
	}
	}
	


