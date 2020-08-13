package com.captians.slangdictionary.controller;

import com.captians.slangdictionary.model.Term;
import com.captians.slangdictionary.model.User;
import com.captians.slangdictionary.other.SearchInput;
import com.captians.slangdictionary.service.TermService;
import com.captians.slangdictionary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    TermService termService;

    @Autowired
    UserService userService;

    @RequestMapping({"/", "/home"})
    public String home(@ModelAttribute("termList") List<Term> terms, @ModelAttribute("searchInput") SearchInput searchInput){
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
//
//    @ModelAttribute("searchInput")
//    public SearchInput getSearchInput(){ return new SearchInput(); }


    @RequestMapping("/thumbup/{term_name}")
    public String thumbup(@PathVariable("term_name") String term_name){
        List<Term> termList = termService.findAll();
        for(Term t : termList){
            if(t.getWord().equals(term_name)){
                Long likes = t.getThumbs_up();
                likes += 1;
                t.setThumbs_up(likes);
                termService.update(t);
            }
        }
        return "redirect:/home";
    }

    @RequestMapping("/thumbdown/{term_name}")
    public String thumbdown(@PathVariable("term_name") String term_name){
        List<Term> termList = termService.findAll();
        for(Term t : termList){
            if(t.getWord().equals(term_name)){
                Long dislikes = t.getThumbs_down();
                dislikes += 1;
                t.setThumbs_down(dislikes);
                termService.update(t);
            }
        }
        return "redirect:/home";
    }
}
