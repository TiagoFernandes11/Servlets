package com.bookstore.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bookstore.entity.Users;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;

public class UserDAO extends JpaDAO<Users> implements BaseDAO<Users>{

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
    	List<Users> users = super.findWithNamedQuery("Users.findByEmail", "email", email);
    	Users user = null;
    	
    	if(users != null && users.size() > 0) {
    		user = users.get(0);
    	}
    	
    	return user;
    }
    
    public boolean checkLogin(String email, String password) {
    	Map<String, Object> parameters = new HashMap<>();
    	parameters.put("email", email);
    	parameters.put("password", password);
    	
    	List<Users> listUsers = super.findWithNamedQuery("Users.checkLogin", parameters);
    	
    	if(listUsers.size() == 1) {
    		return true;
    	}
    	
    	return false;
    }
}
