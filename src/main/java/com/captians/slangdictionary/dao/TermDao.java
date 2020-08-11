package com.captians.slangdictionary.dao;

import com.captians.slangdictionary.model.Term;

import java.util.List;

public interface TermDao {
    public List<Term> findAll();
    public Term findByName(String name);
    public void save(Term t);
}
