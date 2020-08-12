package com.captians.slangdictionary.controller;

import com.captians.slangdictionary.model.EmailConfirmationToken;
import com.captians.slangdictionary.model.User;
import com.captians.slangdictionary.service.EmailService;
import com.captians.slangdictionary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    EmailService emailService;

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

    @RequestMapping(value="/confirm-account", method= {RequestMethod.GET, RequestMethod.POST})
    public String confirmUserAccount(@RequestParam("token")String confirmationToken)
    {
        EmailConfirmationToken token = emailService.findByConfirmationToken(confirmationToken);

        if(token != null)
        {
            User user = userService.findUserByEmail(token.getUser().getEmail());
            user.getUserCredentials().setEnabled(true);
            user.getUserCredentials().setVerifyPassword(user.getUserCredentials().getPassword());
            userService.update(user);
            //create a jsp for success
        }
        else
        {
            //Create a jsp for failure
        }

        return "redirect:/home";
    }
}
