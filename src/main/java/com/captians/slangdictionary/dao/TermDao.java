package com.captians.slangdictionary.dao;

import com.captians.slangdictionary.model.Term;
import java.util.List;

public interface TermDao {
    List<Term> findAll();
    Term findByWord(String word);
    void save(Term t);
    void update(Term t);
}
