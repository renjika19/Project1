package com.fred.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * Servlet implementation class FrontController
 */
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(FrontController.class);
       
	public void init() throws ServletException{
		logger.debug("FRONT CONTROLLER INSTATNIATED");		
	}
    
	
	/*
	 * A front controller is a design pattern for a servlet where this 
	 * servlet acts as the front door for all other servlets in your
	 * application. This design pattern makes a single source servlet handle
	 * all requests and allows you to groom them before sending them to their
	 * destination....Think of it it as a bouncer at an establishment
	 * Typically you want these servlets to be instantiated as soon as a server
	 * is started. This can be done using the <load-on-startup> tag with
	 * a number of 0 or more. Where the lower nubmers will be instantiated
	 * before the higher numbers
	 * 
	 */
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.trace("front controller current uri: " + 
	request.getRequestURI());
		//note that request.getRequestURI() is the URI that we are parsing
		//				website/something.do
		String[] tokens = request.getRequestURI().split("/");
		//gets individual pieces of the URI
		String action = (tokens[tokens.length-1]);//something.do
		action = action.substring(0,action.length()-3).toLowerCase();
		// this give us the "somthing" in "something.do"
		System.out.println(action);
		
		switch(action) {
		case "login":
			request.getRequestDispatcher("LoginServlet")
			.forward(request, response);
			break;
		case "logout":
			if(request.getSession(false)!=null) {
				request.getRequestDispatcher("Logout")
				.forward(request, response);
			}else {
				response.sendError(403);
			}
			break;
		case "register":
			request.getRequestDispatcher("RegisterServlet")
			.forward(request, response);
			break;
		default:
			response.sendError(404);
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

}
