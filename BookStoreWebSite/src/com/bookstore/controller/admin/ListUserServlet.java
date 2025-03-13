package com.bookstore.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.dao.UserDAO;
import com.bookstore.entity.Users;
import com.bookstore.service.UsersServices;

import jakarta.persistence.Persistence;

@WebServlet(name = "ListUsersServlet", urlPatterns = { "/admin/list_users" })
public class ListUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsersServices usersServices = new UsersServices();
		
		List<Users> users = usersServices.listAll();
		
		request.setAttribute("users", users);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admin/list_users.jsp");
		requestDispatcher.forward(request, response);
	}

}
