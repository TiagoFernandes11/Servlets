package com.bookstore.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.entity.Category;
import com.bookstore.service.CategoryServices;


@WebServlet("/admin/delete_category")
public class DeleteCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryServices categoryServices = new CategoryServices();
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		boolean isDeleted = categoryServices.delete(id);
		
		if(isDeleted) {
			request.setAttribute("deleted", "Category ID: " + id + " successfully deleted");
		} else {
			request.setAttribute("notDeleted", "Category ID: " + id + " is already deleted");
		}

		List<Category> categories = categoryServices.findAll();
		request.setAttribute("categories", categories);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admin/list_category.jsp");
		requestDispatcher.forward(request, response);
	}

}
