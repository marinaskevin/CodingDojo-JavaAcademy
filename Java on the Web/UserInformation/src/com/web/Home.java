package com.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Home
 */
@WebServlet(urlPatterns = { "/Home" },description = "A user can choose to give their first name, last name, favorite language, and home town. If a user decides not to provide any of the information we've asked for, then set the default value to be Unknown.")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String favoriteLanguage = request.getParameter("favoriteLanguage");
		String homeTown = request.getParameter("homeTown");

		firstName = firstName != null ? firstName : "Unknown";
		lastName = lastName != null ? lastName : "Unknown";
		favoriteLanguage = favoriteLanguage != null ? favoriteLanguage : "Unknown";
		homeTown = homeTown != null ? homeTown : "Unknown";

		// Sample URLS
		// http://localhost:8080/SimpleProject/Home?firstName=Prairie&lastName=Johnson&favoriteLanguage=Java&homeTown=Burbank
		// http://localhost:8080/SimpleProject/Home?firstName=Prairie&lastName=Johnson&favoriteLanguage=Java
		out.write("<style>body { font-family: 'Comic Sans MS'; }</style>");
		out.write("<h1>Welcome, "+firstName+" "+lastName+"</h1>");
		out.write("<h2>Your favorite language is: "+favoriteLanguage+"</h2>");
		out.write("<h2>Your hometown is: "+homeTown+"</h2>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
