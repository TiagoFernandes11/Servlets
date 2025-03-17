package com.bookstore.dao;

import java.util.List;

import com.bookstore.entity.Category;
import jakarta.persistence.EntityManager;

public class CategoryDAO extends JpaDAO<Category> implements GenericDAO<Category>{

	public CategoryDAO(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public Category update(Category category) {
		super.update(category);
		return category;
	}

	@Override
	public Category get(Object categoryId) {
		Category category = super.find(Category.class, categoryId);
		return category;
	}

	@Override
	public void delete(Object categoryId) {
		super.remove(Category.class, categoryId);		
	}

	@Override
	public List<Category> listAll() {
		return super.findWithNamedQuery("Category.findAll");
	}

	@Override
	public long count() {
		return super.countWithNamedQuery("Category.count");
	}


}
