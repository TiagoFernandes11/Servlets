package com.bookstore.service;

import java.util.List;
import java.util.Objects;

import com.bookstore.dao.UserDAO;
import com.bookstore.entity.Users;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class UsersServices {
	
	private EntityManager entityManager;
	private UserDAO userDao;
	
	public UsersServices() {
		this.entityManager = Persistence.createEntityManagerFactory("BookStoreWebSite").createEntityManager();
		this.userDao = new UserDAO(entityManager);
	}
	
	public Users findUser(Object userId) {
		return userDao.find(Users.class, userId);
	}
	
	public List<Users> listAll(){
		return userDao.listAll();
	}

	public Boolean createUser(Users user) {
		Users userFromDB = userDao.findByEmail(user.getEmail());
		if(Objects.isNull(userFromDB)) {
			userDao.create(user);
			return true;
		} else {
			return false;
		}
	}
	
	public void updateUser(Users user) {
		userDao.update(user);
	}
	
	public void deleteUser(Object userId) {
		userDao.delete(userId);
	}
	
}
