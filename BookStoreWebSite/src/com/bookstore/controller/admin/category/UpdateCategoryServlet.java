package com.bookstore.controller.admin.category;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.entity.Category;
import com.bookstore.service.CategoryServices;


@WebServlet("/admin/update_category")
public class UpdateCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryServices categoryServices;
	
	public UpdateCategoryServlet() {
		super();
		this.categoryServices = new CategoryServices();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer categoryId = Integer.parseInt(request.getParameter("id"));
		Category category = categoryServices.findCategory(categoryId);
		
		request.setAttribute("category", category);
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admin/category_form.jsp");
		requestDispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Category category = new Category();
		
		category.setCategoryId(Integer.parseInt(request.getParameter("id")));
		category.setName(request.getParameter("name"));
		
		boolean isUpdated = categoryServices.update(category);
		
		if(isUpdated) {
			request.setAttribute("success", "Category: " + category.getName() + " successfully updated");
		} else {
			request.setAttribute("error", "Category: " + category.getName() + " could not be founded");
		}
		
		doGet(request, response);
	}

}
