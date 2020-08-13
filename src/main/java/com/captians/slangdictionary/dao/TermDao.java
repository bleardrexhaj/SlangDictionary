package com.captians.slangdictionary.dao;

import com.captians.slangdictionary.model.Term;

import java.util.List;

public interface TermDao {
    public List<Term> findAll();
    public Term findByWord(String word);
    public void save(Term t);
    public void update(Term t);
}
