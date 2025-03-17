package com.bookstore.dao;

import java.util.List;

import com.bookstore.entity.Users;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;

public class UserDAO extends JpaDAO<Users> implements GenericDAO<Users>{

    public UserDAO(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Users create(Users user){
        return super.create(user);
    }

    @Override
    public Users update(Users user) {
        return super.update(user);
    }
    
    @Override
    public Users get(Object userId) {
    	return super.find(Users.class, userId);
    }

    @Override
    public void delete(Object id) {
    	super.remove(Users.class, id);
    }

    @Override
    public List<Users> listAll() {
        return super.findWithNamedQuery("Users.findAll");
    }

    @Override
    public long count() {
    	return super.countWithNamedQuery("Users.countAll");
    }
    
    public Users findByEmail(String email) {
    	Query query = entityManager.createQuery("select u from Users u where u.email='" + email + "'");
    	Users user = null;
    	try {
    		user = (Users) query.getSingleResult();
    	} catch (NoResultException e){
    		
    	}
    	
    	return user;
    }
}
