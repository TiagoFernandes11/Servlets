package com.bookstore.dao;

import java.util.List;

import com.bookstore.entity.Users;

public interface BaseDAO<T> {

    public T create(T t);

    public T update(T t);
    
    public T get(Object entityId);

    public void delete(Object entityId);

    public List<T> listAll();

    public long count();
}
