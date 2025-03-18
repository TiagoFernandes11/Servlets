package com.bookstore.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public abstract class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected EntityManagerFactory entityManagerFactory;
	protected EntityManager entityManager;

	@Override
	public void init() {
		this.entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebSite");
		this.entityManager = this.entityManagerFactory.createEntityManager();
	}
	
	@Override
	public void destroy() {
		this.entityManagerFactory.close();
		this.entityManager.close();
	}
}
