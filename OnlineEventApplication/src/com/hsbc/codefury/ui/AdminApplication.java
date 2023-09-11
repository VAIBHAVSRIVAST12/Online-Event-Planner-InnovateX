package com.hsbc.codefury.ui;

import java.util.List;
import java.util.Scanner;

import com.hsbc.codefdury.beans.Users;
import com.hsbc.codefdury.beans.Vendor;
import com.hsbc.codefury.exceptions.UserNotFoundException;
import com.hsbc.codefury.exceptions.VendorAlreadyExistsException;
import com.hsbc.codefury.exceptions.VendorNotFoundException;
import com.hsbc.codefury.service.impl.AdminServiceImpl;





public class AdminApplication {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AdminServiceImpl service = new AdminServiceImpl();
		
		int choice=0;
		while(choice!=4) {
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
			{   try
			{
				List<Vendor> list=service.viewVendors();
				for(Vendor vndr:list)
					System.out.println(vndr.getVendorId()+vndr.getVendorName()+vndr.getVendorAddress()+vndr.getVendorEmail()+vndr.getVendorContactnumbers());
			}
			catch(VendorNotFoundException vv)
			{
				System.err.println(vv.getMessage());
			}
				break;
			}
			case 3:
			{  try
			{
				List<Users> listuse=service.viewUsers();
				for(Users user:listuse)
					System.out.println(user.getUserFullName()+user.getUsername()+user.getQuotationSelectedId()+user.getUserEmail());
				String choose="";
				while(choose!="All")
				{
				 choose=sc.next();
				
				switch(choose)
				{
				case "Deactivate":
					int userid=sc.nextInt();
					String finalOne=service.activateDeactivate(userid);
					System.out.println(finalOne);
					break;
				
				}
			}
			}
			catch(UserNotFoundException u)
			{
				System.err.println(u.getMessage());
			}
			break;
			}
				
			}
			}
	}
	}
	


