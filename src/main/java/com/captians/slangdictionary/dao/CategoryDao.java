package com.captians.slangdictionary.dao;

import com.captians.slangdictionary.model.Category;
import com.captians.slangdictionary.model.Term;

import java.util.List;

public interface CategoryDao {
    public List<Category> findAll();
    public Category findByName(String name);
    public void save(Category t) throws Exception;
}
