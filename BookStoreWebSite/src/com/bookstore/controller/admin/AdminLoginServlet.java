package com.bookstore.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.service.UsersServices;


@WebServlet("/admin/login")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;     

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admin/login.jsp");
		requestDispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsersServices usersService = new UsersServices();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		if(usersService.checkLogin(email, password)) {
			request.getSession().setAttribute("useremail", email);
			response.sendRedirect(request.getContextPath() + "/admin/");
		} else {
			request.setAttribute("error", "Email or password are incorrect!");
			doGet(request, response);
		}
	}

}
