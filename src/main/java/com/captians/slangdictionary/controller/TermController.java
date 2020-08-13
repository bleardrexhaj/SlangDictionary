package com.captians.slangdictionary.controller;

import com.captians.slangdictionary.model.Term;
import com.captians.slangdictionary.model.User;
import com.captians.slangdictionary.service.TermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
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
            System.out.println(t.getUser().getEmail());
        }
        model.addAttribute("termList", termList);
        return "termlist";
    }



    @RequestMapping(value = "/add")
    public String showAddView(@ModelAttribute("term") Term term){
        System.out.println(term.getWord());
        return "addterm";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@Valid @ModelAttribute Term term, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "addterm";
        }
        termService.addTerm(term);
        return "redirect:/home";
    }
 }
