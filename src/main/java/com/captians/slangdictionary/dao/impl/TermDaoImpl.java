package com.captians.slangdictionary.dao.impl;

import com.captians.slangdictionary.dao.TermDao;
import com.captians.slangdictionary.model.Term;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TermDaoImpl extends GenericDaoImpl<Term> implements TermDao {

    public TermDaoImpl(){
        super.setDaoType(Term.class);
    }

    public List<Term> findAll(){
        return super.findAll();
    }
    public Term findByWord(String word){
        return super.findByWord(word);
    }
    public void save(Term t){
        super.save(t);
    }

    public void update(Term t) { super.upload(t); }
}
