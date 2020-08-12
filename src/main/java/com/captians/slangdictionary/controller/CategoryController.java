package com.captians.slangdictionary.controller;

import com.captians.slangdictionary.model.Category;
import com.captians.slangdictionary.model.Term;
import com.captians.slangdictionary.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "")
    public String getCategoryList(Model model){
        System.out.println("============= category list ==============");
        List<Category> categoryList = categoryService.findAll();
        for (Category t: categoryList) {
            System.out.println(t.getName());
        }
        model.addAttribute("categoryList", categoryList);
        return "categoryList";
    }
}
