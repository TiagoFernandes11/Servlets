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


@WebServlet("/admin/update_user")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsersServices usersServices;
	
	@Override
	   public void init() throws ServletException {
	       super.init();
	       this.usersServices = new UsersServices();
	   }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Users user = usersServices.findUser(request.getParameter("id"));
		
		request.setAttribute("user", user);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admin/user_form.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Users user = new Users();
		
		user.setUserId(Integer.parseInt(request.getParameter("id")));
		user.setFullName(request.getParameter("fullName"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		
		usersServices.updateUser(user);
		
		request.setAttribute("success", "User successfuly updated");
		
		doGet(request, response);
	}

}
