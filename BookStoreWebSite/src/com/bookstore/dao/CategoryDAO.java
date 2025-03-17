package com.bookstore.dao;

import java.util.List;

import com.bookstore.entity.Category;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;

public class CategoryDAO extends JpaDAO<Category> implements GenericDAO<Category>{

	public CategoryDAO(EntityManager entityManager) {
		super(entityManager);
	}
	
	public Category create(Category category) {
		return super.create(category);
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
	
	public Category findByName(String categoryName) {
		Query query = entityManager.createQuery("select c from Category c where c.name = '" + categoryName + "'");
		Category category = null;
		try {
			category = (Category) query.getSingleResult();
		} catch (NoResultException e) {
			
		}
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
