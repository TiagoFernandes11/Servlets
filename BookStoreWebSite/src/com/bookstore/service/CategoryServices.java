package com.bookstore.service;

import java.util.List;

import com.bookstore.dao.CategoryDAO;
import com.bookstore.entity.Category;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class CategoryServices {
	private EntityManager entityManager;
	private CategoryDAO categoryDAO;
	
	public CategoryServices() {
		super();
		this.entityManager = Persistence.createEntityManagerFactory("BookStoreWebSite").createEntityManager();
		this.categoryDAO = new CategoryDAO(entityManager);
	}
	
	public List<Category> findAll(){
		return categoryDAO.listAll();
	}
	
	public boolean create(Category category) {
		Category categoryFromDB = categoryDAO.findByName(category.getName());
		
		if(categoryFromDB != null) {
			return false;
		} else {
			categoryDAO.create(category);
			return true;
		}
	}
	
	public Category findCategory(Object id) {
		return categoryDAO.find(Category.class, id);
	}
	
	public boolean update(Category category) {
		Category categoryFromDB = this.findCategory(category.getCategoryId());
		
		if(categoryFromDB != null) {
			categoryDAO.update(category);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean delete(Object id) {
		Category categoryFromDB = this.findCategory(id);
		
		if(categoryFromDB != null) {
			categoryDAO.delete(id);
			return true;
		} else {
			return false;
		}
	}
}
