package com.bookstore.controller.frontend;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.controller.BaseServlet;
import com.bookstore.entity.Category;
import com.bookstore.service.CategoryServices;

@WebServlet("/")
public class HomeServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryServices categoryServices = new CategoryServices();
		List<Category> listCategory = categoryServices.findAll();
		
		request.setAttribute("listCategory", listCategory);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/frontend/index.jsp");
		requestDispatcher.forward(request, response);
		
	}

}
