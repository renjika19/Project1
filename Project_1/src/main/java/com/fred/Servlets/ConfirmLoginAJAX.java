package com.fred.Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.fred.Services.ers_user_service;

public class ConfirmLoginAJAX extends HttpServlet {
	private static long serialVersionUID = 1L;
	
	
	public ConfirmLoginAJAX() {
		super();
	}
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		
		if(new ers_user_service().usernameExists(username)){
			out.print("USERNAME TAKEN");
			return;
		}else {
			out.println("USERNAME AVAILABLE");
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
	
	
	
	
}
