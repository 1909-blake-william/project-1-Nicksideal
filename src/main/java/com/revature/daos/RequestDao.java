package com.revature.daos;

import java.util.List;

import com.revature.models.Request;

public interface RequestDao {
	
	RequestDao currentImplementation = new RequestDaoSQL();
	
	int save(Request r);
	
	List<Request> findAll();
	
	List<Request> findByUsername(String username);
	
	List<Request> findByStatus();
	
	void evaluateRequest(int req_id, int req_status_id);
}
