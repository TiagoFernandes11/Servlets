package com.bookstore.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.entity.Users;
import com.bookstore.service.UsersServices;


@WebServlet("/admin/create_user")
public class CreateUserServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private UsersServices usersServices;
	
	@Override
	   public void init() throws ServletException {
	       super.init();
	       this.usersServices = new UsersServices();
	   }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admin/user_form.jsp");
		requestDispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Users user = new Users();
		user.setEmail(request.getParameter("email"));
		user.setFullName(request.getParameter("fullName"));
		user.setPassword(request.getParameter("password"));
		
		if (usersServices.createUser(user)) {
	        request.setAttribute("success", "User successfully created");
	    } else {
	        request.setAttribute("error", "This email is already registered");
	    }
		
		this.doGet(request, response);
	}

}
