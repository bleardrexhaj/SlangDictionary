package com.captians.slangdictionary.service.impl;

import com.captians.slangdictionary.dao.TermDao;
import com.captians.slangdictionary.dao.impl.TermDaoImpl;
import com.captians.slangdictionary.model.Term;
import com.captians.slangdictionary.service.TermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TermServiceImpl implements TermService {

    @Autowired
    private TermDao termDao;

    public List<Term> findAll(){
        return termDao.findAll();
    }
    public Term findByName(String name){
        return termDao.findByName(name);
    }
    public void addTerm(Term term){
        termDao.save(term);
    }
}
