package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.daos.UserDao;
import com.revature.models.User;

public class AuthUtilServlet extends HttpServlet{
	
	private UserDao userDao = UserDao.currentImplementation;
	public AuthUtilServlet() { new ObjectMapper(); }
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//System.out.println("uri = " + req.getRequestURI());
		resp.addHeader("Access-Control-Allow-Origin", "http://localhost:5500");
		resp.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
		resp.addHeader("Access-Control-Allow-Headers",
				"Origin, Methods, Credentials, X-Requested-With, Content-Type, Accept");
		resp.addHeader("Access-Control-Allow-Credentials", "true");
		resp.setContentType("application/json");
		// TODO Auto-generated method stub
		super.service(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("uri = " + req.getRequestURI());
		if ("/RequestApi/auth/login".equals(req.getRequestURI())) {
			//Gson gson = new Gson();
			ObjectMapper om = new ObjectMapper();
			User credentials = (User) om.readValue(req.getReader(), User.class);
			
			System.out.println("credentials received " + credentials.getUsername());
			//User credentials = (User) gson.fromJson(req.getReader(), User.class);
			//User loggedInUser = userDao.findByUsernameAndPassword(credentials.getUsername(), credentials.getPassword());
			User loggedInUser = userDao.findByUsernameAndPassword(credentials.getUsername(), credentials.getPassword());
			System.out.println(loggedInUser);
			if (loggedInUser == null) {
				resp.setStatus(401); // Unauthorized status code
				return;
			} else {
				resp.setStatus(201);
				req.getSession().setAttribute("user", loggedInUser);
				System.out.println("Jae says anything");
				resp.getWriter().write(om.writeValueAsString(loggedInUser));
//				resp.getWriter().write(gson.toJson(loggedInUser));
				return;
			}
		}
		if ("/RequestApi/auth/logout".equals(req.getRequestURI())) {
			
			resp.setStatus(201); // success code
			req.getSession().invalidate();
			return;
			}
		
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("hello77");
		if ("/RequestApi/auth/session-user".equals(req.getRequestURI())) {
			ObjectMapper om = new ObjectMapper();
//			Gson gson = new Gson();
			String json = om.writeValueAsString(req.getSession().getAttribute("user"));
//			String json = gson.toJson(req.getSession().getAttribute("user"));
			resp.getWriter().write(json);
		}
	}

}
