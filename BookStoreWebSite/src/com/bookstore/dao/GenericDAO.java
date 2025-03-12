package com.bookstore.dao;

import java.util.List;

import com.bookstore.entity.Users;

public interface GenericDAO<T> {

    public T create(T t);

    public T update(Users user);
    
    public T get(Object userId);

    public void delete(Object id);

    public List<T> listAll();

    public long count();
}
