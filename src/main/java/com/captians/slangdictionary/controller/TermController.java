package com.captians.slangdictionary.controller;

import com.captians.slangdictionary.model.Term;
import com.captians.slangdictionary.model.User;
import com.captians.slangdictionary.service.TermService;
import com.captians.slangdictionary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/term")
public class TermController {

    @Autowired
    TermService termService;
    @Autowired
    UserService userService;

    @RequestMapping(value = {"/", "/list"})
    public String getTermList(Model model) {
        System.out.println("============= list ==============");
        List<Term> termList = termService.findAll();
        for (Term t: termList) {
            System.out.println(t.getUser().getEmail());
        }
        model.addAttribute("termList", termList);
        return "termlist";
    }



    @RequestMapping(value = "/add")
    public String showAddView(@ModelAttribute("term") Term term){
        return "addterm";
    }

    @RequestMapping(value = "/addTerm", method = RequestMethod.POST)
    public String add(@ModelAttribute("term") Term term, BindingResult bindingResult){
        System.out.println(term);
        Object principal =  SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userName = ((UserDetails)principal).getUsername();
        User user = userService.findUserByUserName(userName);
        term.setUser(user);
        term.setWritten_on(new Date());
        term.setAuthor(user.getFirstName());
        term.setThumbs_up((long) 0);
        term.setThumbs_down((long) 0);
        if(bindingResult.hasErrors()){
            return "addterm";
        }
        termService.addTerm(term);
        return "redirect:/home";
    }
 }
