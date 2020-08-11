package com.captians.slangdictionary.service;

import com.captians.slangdictionary.model.Category;
import com.captians.slangdictionary.model.Term;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category findByName(String name);
    void addCategory(Category category);
}
