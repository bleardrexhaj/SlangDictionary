package com.captians.slangdictionary.dao.impl;

import com.captians.slangdictionary.dao.CategoryDao;
import com.captians.slangdictionary.model.Category;
import com.captians.slangdictionary.model.Term;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDaoImpl extends GenericDaoImpl<Category> implements CategoryDao {
    public CategoryDaoImpl(){
        super.setDaoType(Category.class);
    }

    public List<Category> findAll(){
        return super.findAll();
    }
    public void save(Category t){
        super.save(t);
    }
}
