package com.captians.slangdictionary.dao;

import com.captians.slangdictionary.model.Term;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public interface TermDao {
    public List<Term> findAll();
    public Term findByWord(String word);
    public void save(Term t);
    public void update(Term t);
}
