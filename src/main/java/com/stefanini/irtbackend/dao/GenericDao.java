package com.stefanini.irtbackend.dao;

import java.util.List;

public interface GenericDao<T> {

    T findById(Long id);

    List<T> findAll();

    boolean create(T t);

    T update(T t);

    void delete(T t);
}
