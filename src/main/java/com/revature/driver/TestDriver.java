package com.revature.driver;

import com.revature.daos.RequestDao;
import com.revature.daos.UserDao;
import com.revature.models.Request;

public class TestDriver {
	
	
	public static void main(String[] args) {
		UserDao userDao= UserDao.currentImplementation;
		RequestDao requestDao = RequestDao.currentImplementation;
		
		
		int r= 2;
		System.out.println(requestDao.findAll());
	}

}
