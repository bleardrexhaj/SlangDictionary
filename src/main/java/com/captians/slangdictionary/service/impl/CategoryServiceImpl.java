package com.captians.slangdictionary.service.impl;

import com.captians.slangdictionary.dao.CategoryDao;
import com.captians.slangdictionary.dao.TermDao;
import com.captians.slangdictionary.model.Category;
import com.captians.slangdictionary.model.Term;
import com.captians.slangdictionary.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;

    public List<Category> findAll(){
        return categoryDao.findAll();
    }
    public Category findByName(String name){
        return categoryDao.findByName(name);
    }
    public void addCategory(Category category) throws Exception {
        categoryDao.save(category);
    }
}
