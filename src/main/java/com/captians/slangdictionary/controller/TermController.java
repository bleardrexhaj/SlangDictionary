package com.captians.slangdictionary.controller;

import com.captians.slangdictionary.model.Term;
import com.captians.slangdictionary.service.TermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/term")
public class TermController {

    @Autowired
    TermService termService;


    @RequestMapping(value = "/list")
    public String getTermList(Model model) {
        System.out.println("============= list ==============");
        List<Term> termList = termService.findAll();
        for (Term t: termList) {
            System.out.println(t.getAuthor());
        }
        model.addAttribute("termList", termList);
        return "termlist";
    }
 }
