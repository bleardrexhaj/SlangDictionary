package com.captians.slangdictionary.dao.impl;

import com.captians.slangdictionary.dao.TermDao;
import com.captians.slangdictionary.model.Term;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TermDaoImpl extends GenericDaoImpl<Term> implements TermDao {
    public List<Term> findAll(){
        return super.findAll();
    }
    public Term findByName(String name){
        return super.findByName(name);
    }
    public void save(Term t){
        super.save(t);
    }
}
