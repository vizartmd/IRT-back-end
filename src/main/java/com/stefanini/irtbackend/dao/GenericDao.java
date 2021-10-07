package com.stefanini.irtbackend.dao;

import java.util.List;

public interface GenericDao<T> {

    T findById(Long id);

    List<T> findAll();

    void create(T t);

    void update(T t);

    void delete(T t);
}
