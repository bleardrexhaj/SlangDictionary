package com.captians.slangdictionary.controller;

import com.captians.slangdictionary.model.Category;
import com.captians.slangdictionary.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import java.util.List;

@Controller
@RequestMapping(value = "/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "")
    public String getCategoryList(Model model){
        List<Category> categoryList = categoryService.findAll();
        for (Category t: categoryList) {
            System.out.println(t.getName());
        }
        model.addAttribute("categoryList", categoryList);
        return "categoryList";
    }

    @RequestMapping(value = "/{category}", method = RequestMethod.GET)
    public String terms(@PathVariable("category") String categoryName, Model model){
        List<Category> categoryList = categoryService.findAll();
        for(Category cat : categoryList){
            if(cat.getName().equals(categoryName)){
                model.addAttribute("termList", cat.getTerms());
                return "categoryTerms";
            }
        }
        return "";
    }
}
