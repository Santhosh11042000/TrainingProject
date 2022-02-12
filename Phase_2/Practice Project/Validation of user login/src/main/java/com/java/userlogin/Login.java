package com.java.userlogin;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Set the content type
		response.setContentType("text/html");
		
//		Get the writer
		PrintWriter out = response.getWriter();
		
//		Get the userName from the request
		String uName = request.getParameter("userName");
		String uPassword = request.getParameter("userPassword");
		
//		Get a reference to the HttpSession object
		HttpSession theSession = request.getSession();
		
//		Validate the username
		if(uName.trim().equals("abcd")  && uPassword.trim().equals("1234")) {
//			Save the username in the session
			theSession.setAttribute("userName", uName);
			theSession.setAttribute("userPassword", uPassword);
//			Redirect to the Dashboard
			response.sendRedirect("dashboard");
			
		}
		else {
			out.println("<font color='red'>Invalid username or Password...</font>");
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
			dispatcher.include(request, response);
		}
		

	}

}