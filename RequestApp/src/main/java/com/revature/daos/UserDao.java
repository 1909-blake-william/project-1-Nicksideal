package com.revature.daos;

public interface UserDao {
	
	UserDao currentImplementation = new userDaoSQL();
	
	

}
