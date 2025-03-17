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


@WebServlet("/admin/delete_user")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsersServices usersServices;
       

    public DeleteUserServlet() {
        super();
        this.usersServices = new UsersServices();
    }
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Object deletedUserId = request.getParameter("id");
    	Users userFromDb = usersServices.findUser(deletedUserId);
    	
    	if(userFromDb != null && userFromDb.getUserId() > 0) {	
        	usersServices.deleteUser(deletedUserId);	
        	request.setAttribute("deletedUserId", deletedUserId);
    	} else {
    		request.setAttribute("notDeletedUserId", deletedUserId);
    	}
    	
    	RequestDispatcher requestDispatcher = request.getRequestDispatcher("/admin/list_users");
    	requestDispatcher.forward(request, response);
    }

}
