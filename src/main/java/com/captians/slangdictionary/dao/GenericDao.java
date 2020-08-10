package com.captians.slangdictionary.dao;

import java.util.List;

public interface GenericDao<T> {
    T save(T t);
    T upload(T t);
    List<T> findAll();
    T findOne(Long id);
    void delete(T t);
}
