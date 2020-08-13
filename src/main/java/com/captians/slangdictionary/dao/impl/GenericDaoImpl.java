package com.captians.slangdictionary.dao.impl;

import com.captians.slangdictionary.dao.GenericDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class GenericDaoImpl<T> implements GenericDao<T> {
    @PersistenceContext
    protected EntityManager persistence;

    protected Class<T> daoType;

    public void setDaoType(Class<T> type) {
        daoType = type;
    }

    @Override
    public void save(T t) {
        persistence.persist(t);
    }

    @Override
    public T upload(T t) {
        return persistence.merge(t);
    }

    @Override
    public List<T> findAll() {
        return persistence.createQuery( "from " + daoType.getName()).getResultList();
    }

    @Override
    public T findOne(Long id) {
        return persistence.find(daoType,id);
    }

    @Override
    public T findByName(String name) {
        return (T) persistence.createQuery("from "+ daoType.getName() +" where name="+name).getSingleResult();
    }

    public T findByWord(String word) {
        return (T) persistence.createQuery("from "+ daoType.getName() +" where word="+word).getSingleResult();
    }

    @Override
    public void delete(T t) {

    }
}
