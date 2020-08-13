package com.captians.slangdictionary.controller;

import com.captians.slangdictionary.model.Term;
import com.captians.slangdictionary.model.User;
import com.captians.slangdictionary.service.TermService;
import com.captians.slangdictionary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    TermService termService;

    @Autowired
    UserService userService;

    @RequestMapping({"/", "/home"})
    public String home(@ModelAttribute("termList") List<Term> terms){
        return "homepage";
    }

    @RequestMapping("/myterms")
    public String terms(Model model){
        Object principal =  SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userName = ((UserDetails)principal).getUsername();
        User user = userService.findUserByUserName(userName);
        model.addAttribute("terms", user.getTerms());
        return "userterms";
    }

    @ModelAttribute("termList")
    public List<Term> getTerms(){
        return termService.findAll();
    }
}
