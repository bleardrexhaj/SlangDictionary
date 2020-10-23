package com.captians.slangdictionary.service.impl;

import com.captians.slangdictionary.dao.TermDao;
import com.captians.slangdictionary.model.Term;
import com.captians.slangdictionary.service.TermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TermServiceImpl implements TermService {

    private final TermDao termDao;

    @Autowired
    public TermServiceImpl(TermDao termDao) {
        this.termDao = termDao;
    }

    public List<Term> findAll(){
        return termDao.findAll();
    }
    public Term findByWord(String word){
        return termDao.findByWord(word);
    }
    public void addTerm(Term term){
        termDao.save(term);
    }
    public void update(Term t){ termDao.update(t); }
}
