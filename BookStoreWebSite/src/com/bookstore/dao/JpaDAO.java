package com.bookstore.dao;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

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
    
    public List<E> findWithNamedQuery(String queryName){
    	Query query = entityManager.createNamedQuery(queryName);
    	return query.getResultList();
    }
    
    public List<E> findWithNamedQuery(String queryName, String paramName, Object paramValue){
    	Query query = entityManager.createNamedQuery(queryName);
    	query.setParameter(paramName, paramValue);
    	
    	return query.getResultList();
    }
    
    public List<E> findWithNamedQuery(String queryName, Map<String, Object> parameters){
    	Query query = entityManager.createNamedQuery(queryName);
    	
    	Set<Entry<String, Object>> rawParameters = parameters.entrySet();
    	
    	for(Entry<String, Object> entry : rawParameters) {
        	query.setParameter(entry.getKey(), entry.getValue());		
    	}
    	
    	return query.getResultList();
    }
    
    public Long countWithNamedQuery(String namedQuery) {
    	Query query = entityManager.createNamedQuery(namedQuery);
    	return (Long) query.getSingleResult();
    }
    
    public void remove(Class<E> type, Object userId) {
    	entityManager.getTransaction().begin();
    	
    	Object reference = entityManager.getReference(type, userId);
    	entityManager.remove(reference);
    	
    	entityManager.getTransaction().commit();
    }
    
    public void closeEntityManager() {
    	entityManager.close();
    }
}
