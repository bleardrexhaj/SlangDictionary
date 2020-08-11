package com.captians.slangdictionary.dao;

import java.util.List;

public interface GenericDao<T> {
    void save(T t);
    T upload(T t);
    List<T> findAll();
    T findOne(Long id);
    T findByName(String name);
    void delete(T t);
}
