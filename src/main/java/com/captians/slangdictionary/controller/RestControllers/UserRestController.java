package com.captians.slangdictionary.controller.RestControllers;

import com.captians.slangdictionary.dto.UserMessage;
import com.captians.slangdictionary.model.EmailConfirmationToken;
import com.captians.slangdictionary.model.User;
import com.captians.slangdictionary.service.EmailService;
import com.captians.slangdictionary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class UserRestController {

    private final UserService userService;
    private final EmailService emailService;

    @Autowired
    UserRestController(UserService userService, EmailService emailService){
        this.userService = userService;
        this.emailService = emailService;
    }

    @GetMapping(value = "/test", produces = MediaType.APPLICATION_XML_VALUE)
    public @ResponseBody ResponseEntity<?> test(){
        return ResponseEntity.ok(new UserMessage("XML TEST"));
    }

    @PostMapping(value = "/register")
    public ResponseEntity<?> saveUser(@Valid @RequestBody User user, Errors bindingResult) throws Exception {
        UserMessage userMessage = new UserMessage();
        if(bindingResult.hasErrors()){
            userMessage.setMessage("Fail");
            userMessage.setHttpStatus(HttpStatus.BAD_REQUEST);
            userMessage.setErrors(bindingResult.getFieldErrors());
            return new ResponseEntity<>(userMessage, userMessage.getHttpStatus());
        }
        try {
            userService.save(user);
        } catch (DataIntegrityViolationException exception){
            userMessage.setMessage(exception.getMessage());
            userMessage.setHttpStatus(HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(userMessage, userMessage.getHttpStatus());
        }
        userMessage.setMessage("Success");
        userMessage.setHttpStatus(HttpStatus.OK);
        return new ResponseEntity<>(userMessage, userMessage.getHttpStatus());
    }

    @RequestMapping(value="/confirm-account", method= {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<?> confirmUserAccount(@RequestParam("token")String confirmationToken)
    {
        EmailConfirmationToken token = null;
        UserMessage userMessage = new UserMessage();
        try {
            token = emailService.findByConfirmationToken(confirmationToken);
        } catch (Exception e){
            userMessage.setMessage(e.getMessage());
            userMessage.setHttpStatus(HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(userMessage, userMessage.getHttpStatus());
        }

        if(token != null)
        {
            User user = userService.findUserByEmail(token.getUser().getEmail());
            user.getUserCredentials().setEnabled(true);
            user.getUserCredentials().setVerifyPassword(user.getUserCredentials().getPassword());
            userService.update(user);
            userMessage.setMessage("success");
            userMessage.setHttpStatus(HttpStatus.OK);
        }
        else
        {
            userMessage.setMessage("save failed!");
            userMessage.setHttpStatus(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(userMessage, userMessage.getHttpStatus());
    }
}
