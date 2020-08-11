package com.captians.slangdictionary.service;

import com.captians.slangdictionary.model.Term;

import java.util.List;

public interface TermService {

    public List<Term> findAll();
    public Term findByName(String name);
    public void addTerm(Term term);

}
