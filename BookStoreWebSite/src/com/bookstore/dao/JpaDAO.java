package com.bookstore.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class JpaDAO<E> {

    protected EntityManager entityManager;

    public JpaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public E create(E entity){
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(entity);
        this.entityManager.flush();
        this.entityManager.refresh(entity);
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
        return entity;
    }

    public E update(E entity){
        entityManager.getTransaction().begin();
        entity = entityManager.merge(entity);
        entityManager.getTransaction().commit();
        return entity;
    }
    
    public E find(Class<E> type, Object id) {
    	E entity = entityManager.find(type, id);
    	if(entity != null) {
        	entityManager.refresh(entity);
    	}
    	return entity;
    }
    
    public void remove(Class<E> type, Object userId) {
    	entityManager.getTransaction().begin();
    	
    	Object reference = entityManager.getReference(type, userId);
    	entityManager.remove(reference);
    	
    	entityManager.getTransaction().commit();
    }
}
