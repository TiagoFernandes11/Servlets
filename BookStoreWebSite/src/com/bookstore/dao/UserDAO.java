package com.bookstore.dao;

import jakarta.persistence.EntityManager;
import com.bookstore.entity.Users;

import java.util.ArrayList;
import java.util.List;

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
    public void delete(Object id) {

    }

    @Override
    public List<Users> listAll() {
        return new ArrayList<Users>();
    }

    @Override
    public long count() {
        return 0;
    }
}
