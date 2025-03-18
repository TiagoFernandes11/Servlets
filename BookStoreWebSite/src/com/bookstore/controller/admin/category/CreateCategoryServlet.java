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


@WebServlet("/admin/create_category")
public class CreateCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryServices categoryServices;
	

	@Override
	   public void init() throws ServletException {
	       super.init();
	       this.categoryServices = new CategoryServices();
	   }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admin/category_form.jsp");
		requestDispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Category category = new Category();
		category.setName(request.getParameter("name"));
		
		if(categoryServices.create(category)){
			request.setAttribute("success", "Category successfuly " + category.getName() + " created");
		} else {
			request.setAttribute("error", "Category name already exists");
		}
		
		doGet(request, response);
	}

}
