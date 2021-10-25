package com.stefanini.irtbackend.dao;

import java.util.List;
import java.util.Optional;

public interface GenericDao<T> {

    Optional<T> findById(Long id);

    List<T> findAll();

    T create(T t);

    T update(T t);

    void delete(T t);
}
