package com.captians.slangdictionary.service;

import com.captians.slangdictionary.model.Term;

import java.util.List;

public interface TermService {

    List<Term> findAll();
    Term findByWord(String word);
    void addTerm(Term term);
    public void update(Term t);
}
