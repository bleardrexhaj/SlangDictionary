package com.captians.slangdictionary.controller;

import com.captians.slangdictionary.model.EmailConfirmationToken;
import com.captians.slangdictionary.model.User;
import com.captians.slangdictionary.service.EmailService;
import com.captians.slangdictionary.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class UserController {

    private final UserService userService;

    private final EmailService emailService;

    public UserController(UserService userService, EmailService emailService) {
        this.userService = userService;
        this.emailService = emailService;
    }

    @RequestMapping("/register")
    public String register(@ModelAttribute("user") User user){
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String saveUser(@Valid @ModelAttribute User user, BindingResult bindingResult, RedirectAttributes redirectAttributes) throws Exception {
        if(bindingResult.hasErrors()){
            return register(user);
        } else {
            userService.save(user);
        }
        redirectAttributes.addFlashAttribute("email", user.getEmail());
        return "redirect:/confirmAccount";
    }

    @RequestMapping(value="/confirm-account", method= {RequestMethod.GET, RequestMethod.POST})
    public String confirmUserAccount(@RequestParam("token")String confirmationToken)
    {
        EmailConfirmationToken token = null;
        try {
            token = emailService.findByConfirmationToken(confirmationToken);
        } catch (Exception e){
            return "accountConfirmation/account-confirmation-error";
        }

        if(token != null)
        {
            User user = userService.findUserByEmail(token.getUser().getEmail());
            user.getUserCredentials().setEnabled(true);
            user.getUserCredentials().setVerifyPassword(user.getUserCredentials().getPassword());
            userService.update(user);
            return "accountConfirmation/account-confirmation-success";
        }
        else
        {
            return "accountConfirmation/account-confirmation-error";
        }
    }

    @RequestMapping("/confirmAccount")
    public String confirmAccount(Model model, @ModelAttribute("email") String email){
        model.addAttribute("email", email);
        return "accountConfirmation/account-confirmation";
    }
}
