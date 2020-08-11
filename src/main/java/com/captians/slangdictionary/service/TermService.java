package com.captians.slangdictionary.service;

import com.captians.slangdictionary.model.Term;

import java.util.List;

public interface TermService {

    List<Term> findAll();
    Term findByName(String name);
    void addTerm(Term term);

}
