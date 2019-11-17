package com.revature.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.daos.RequestDao;
import com.revature.daos.UserDao;
import com.revature.models.Request;
import com.revature.models.User;

public class RequestServlet extends HttpServlet {

	private RequestDao requestDao = RequestDao.currentImplementation;
	private UserDao userDao = UserDao.currentImplementation;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		if ("/RequestApi/requests".equals(req.getRequestURI())) {
			List<Request> request;
			
			String userName = req.getParameter("userName");

			if (userName != null) { // find by trainer name
				request = requestDao.findByUsername(userName);
			} else { // find all
				request = requestDao.findAll();
			}
			
			ObjectMapper om = new ObjectMapper();
			String json = om.writeValueAsString(request);

			resp.addHeader("content-type", "application/json");
			resp.getWriter().write(json);

			System.out.println("uri = " + req.getRequestURI());
		}
		if ("/RequestApi/auth/login".equals(req.getRequestURI())) {
			ObjectMapper om = new ObjectMapper();
			User credentials = (User) om.readValue(req.getReader(), User.class);
			User loggedInUser = userDao.findByUsernameAndPassword(credentials.getUsername(), credentials.getPassword());
			if (loggedInUser == null) {
				resp.setStatus(401); // Unauthorized status code
				return;
			} else {
				resp.setStatus(201);
				req.getSession().setAttribute("user", loggedInUser);
				resp.getWriter().write(om.writeValueAsString(loggedInUser));
				return;
			}
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if ("/RequestApi/requests/submit".equals(req.getRequestURI())) {
			List<Request> request;
			
			ObjectMapper om = new ObjectMapper();
			Request r = (Request) om.readValue(req.getReader(), Request.class);
			
			request = requestDao.save(r);
			
			String json = om.writeValueAsString(request);
			resp.getWriter().write(json);
			resp.setStatus(201); 
		}
	}
}
