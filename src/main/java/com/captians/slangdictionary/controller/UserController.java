package com.captians.slangdictionary.controller;

import com.captians.slangdictionary.model.User;
import com.captians.slangdictionary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/register")
    public String register(@ModelAttribute("user") User user){
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String saveUser(@Valid @ModelAttribute User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return register(user);
        } else {
            userService.save(user);
        }
        return "redirect:/home";
    }
}
