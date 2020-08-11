package com.captians.slangdictionary.controller;


import com.captians.slangdictionary.model.Term;
import com.captians.slangdictionary.service.TermService;
import com.captians.slangdictionary.service.impl.TermServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/term")
public class TermController {

    @Autowired
    TermService termService;

    @RequestMapping(value = "/list")
    public List<Term> getTermList(){
        System.out.println("============= list ==============");
        return termService.findAll();
    }
 }
