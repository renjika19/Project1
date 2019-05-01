package com.fred.Servlets;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fred.Services.ers_user_service;
import com.fred.util.HtmlTemplate;

	/**
 * Servlet implementation class RegisterServlet
 */
public class Register_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(Register_servlet.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ers_username = request.getParameter("ers_username");
		String ers_password1 = request.getParameter("ers_password1");
		String ers_password2 = request.getParameter("ers_password2");
		String user_email = request.getParameter("user_email");
		
		
		
		PrintWriter out = HtmlTemplate.getHtmlOut(response);
		
		//Confirm that the user did not enter information in maliciously
		//(nulls or empty strings against front end validation)
		if(ers_username==null||ers_password1==null||ers_password2==null||user_email==null||
			ers_username.equals("")||ers_password1.equals("")||ers_password2.equals("")||user_email.equals("")) {
			response.sendError(418);
			return;
		}
		
		//Confirm passwords match
		if(!ers_password1.equals(ers_password2)) {
			out.println("<h3 style ='color:red'>Passwords do not match!</h3>");
			
			HtmlTemplate.goBack(out);
			return;
		}
		
		//Confirm username exists 
				if(new ers_user_service().ers_usernameExists(ers_username)) {
					out.println("<h3 style ='color:red'>ers_username Taken!</h3>");
					
					HtmlTemplate.goBack(out);
					return;
				}
				
				if(new ers_user_service().registerers_user(ers_username, ers_password1, user_email)) {
					out.println("<h3 style ='color:aliceblue'>"
							+ers_username.toUpperCase()+" CREATED!"
							+ "</h3>");
					HtmlTemplate.goBack(out);
					return;
				}else {
					out.println("<h3 style ='color:red'>"
							+"An ERROR occurred during REGISTRATION"
							+ "</h3>");
					HtmlTemplate.goBack(out);
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

