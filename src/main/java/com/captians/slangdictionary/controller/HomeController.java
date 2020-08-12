package com.captians.slangdictionary.controller;

import com.captians.slangdictionary.model.Term;
import com.captians.slangdictionary.service.TermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    TermService termService;

    @RequestMapping({"/", "/home"})
    public String home(@ModelAttribute("termList") List<Term> terms){
        return "homepage";
    }

    @ModelAttribute("termList")
    public List<Term> getTerms(){
        return termService.findAll();
    }
}
