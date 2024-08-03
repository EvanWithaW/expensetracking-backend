package com.evanwithaw.expensetracking.controllers;

import com.evanwithaw.expensetracking.models.User;
import com.evanwithaw.expensetracking.services.AuthUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AuthController {

    @Autowired
    private AuthUserService authUserService;

    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity<String> register(@RequestBody User user){
        authUserService.registerUser(user);
        return ResponseEntity.ok("Registered Successfully");
    }

}
