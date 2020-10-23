package com.captians.slangdictionary.controller;

import com.captians.slangdictionary.dto.AuthenticationResponse;
import com.captians.slangdictionary.dto.UserMessage;
import com.captians.slangdictionary.dto.AuthenticationRequest;
import com.captians.slangdictionary.service.UserService;
import com.captians.slangdictionary.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private final UserService userService;

    private final JwtUtil jwtUtil;

    private final AuthenticationManager authenticationManager;

    @Autowired
    public LoginController(UserService userService, JwtUtil jwtUtil, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest userLogin) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLogin.getUsername(), userLogin.getPassword()));
        } catch (Exception e) {
            return new ResponseEntity<>(new UserMessage(e.getMessage()), HttpStatus.BAD_REQUEST);
        }

        final String token = jwtUtil.generateToken(userService.findUserByUserName(userLogin.getUsername()));
        return new ResponseEntity<>(new AuthenticationResponse(token), HttpStatus.ACCEPTED);
    }
}
