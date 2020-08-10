package com.captians.slangdictionary.dao.impl;

import com.captians.slangdictionary.dao.GenericDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class GenericDaoImpl<T> implements GenericDao<T> {
    @PersistenceContext
    private EntityManager persistence;

    @Override
    public T save(T t) {
        return null;
    }

    @Override
    public T upload(T t) {
        return null;
    }

    @Override
    public List<T> findAll() {
        return null;
    }

    @Override
    public T findOne(Long id) {
        return null;
    }

    @Override
    public T findByName(String name) {
        return null;
    }

    @Override
    public void delete(T t) {

    }
}
