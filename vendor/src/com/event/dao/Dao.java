package com.event.dao;

import com.event.beans.Packages;
import com.event.beans.Quotation;

public interface Dao {
	int addPackage(Packages p);
	int createQuoation(Quotation q);
	void getPackages();
	

}
