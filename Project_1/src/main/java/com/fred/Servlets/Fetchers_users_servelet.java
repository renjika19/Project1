package com.fred.Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.fred.Beans.ers_user;


import com.fred.Services.ers_user_service;

public class Fetchers_users_servelet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Fetchers_users_servelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * Jackson Mapper
		 * 
		 * We will use this object in order to conver the java object
		 * (obtained via JDBC) and turn it into a JSON string representation
		 * of the data. This will make for handling any data passed from java
		 * to javascript significantly easier to work with
		 */
		List<ers_user> ers_userss = new ers_user_service().getAllers_users();
		ObjectMapper om = new ObjectMapper();
		
		//tell the client that it will be receiving JSON formatted data
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		//Convert the collection into a JSON string representation
		out.println(om.writeValueAsString(ers_userss));
		//very crudely like stringify
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
