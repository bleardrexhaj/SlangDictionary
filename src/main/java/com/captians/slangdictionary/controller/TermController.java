package com.captians.slangdictionary.controller;

import com.captians.slangdictionary.model.Category;
import com.captians.slangdictionary.model.Term;
import com.captians.slangdictionary.model.User;
import com.captians.slangdictionary.service.CategoryService;
import com.captians.slangdictionary.service.TermService;
import com.captians.slangdictionary.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/term")
public class TermController {

    private final TermService termService;
    private final UserService userService;
    private final CategoryService categoryService;

    public TermController(TermService termService, UserService userService, CategoryService categoryService) {
        this.termService = termService;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @RequestMapping(value = {"/", "/list"})
    public String getTermList(Model model) {
        model.addAttribute("termList", termService.findAll());
        return "termlist";
    }

    @RequestMapping(value= "/search")
    public String searchTerm(@RequestParam String input, Model model){
        List<Term> list = termService.findAll().stream().filter((term -> term.getWord().equals(input))).collect(Collectors.toList());
        model.addAttribute("termList", list);
        return "termlist";
    }

    @RequestMapping(value = "/add")
    public String showAddView(Model model, @ModelAttribute("term") Term term){
        model.addAttribute("categoryList", categoryService.findAll());
        return "addterm";
    }

    @RequestMapping(value = "/addTerm", method = RequestMethod.POST)
    public String add(@ModelAttribute("term") Term term, BindingResult bindingResult){
        Object principal =  SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userName = ((UserDetails)principal).getUsername();
        User user = userService.findUserByUserName(userName);
        term.setUser(user);
        term.setWritten_on(new Date());
        term.setAuthor(user.getFirstName());
        term.setThumbs_up((long) 0);
        term.setThumbs_down((long) 0);
        List<Category> categoryList = categoryService.findAll();
//        for(Category cat : categoryList){
//            if(cat.getName().equals(category_name)) term.setCategory(cat);
//        }
        if(bindingResult.hasErrors()){
            return "addterm";
        }
        termService.addTerm(term);
        return "redirect:/home";
    }
 }
