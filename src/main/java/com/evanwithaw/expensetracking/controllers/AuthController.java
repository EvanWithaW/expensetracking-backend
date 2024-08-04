package com.evanwithaw.expensetracking.controllers;

import com.evanwithaw.expensetracking.dtos.LoginUserDto;
import com.evanwithaw.expensetracking.dtos.RegisterUserDto;
import com.evanwithaw.expensetracking.models.User;
import com.evanwithaw.expensetracking.services.AuthService;
import com.evanwithaw.expensetracking.services.JwtService;
import com.evanwithaw.expensetracking.utils.LoginResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RequestMapping("auth")
@RestController
public class AuthController {
    private static final Logger log = LoggerFactory.getLogger(AuthController.class);
    private final JwtService jwtService;

    private final AuthService authService;

    public AuthController(JwtService jwtService, AuthService authService){
        this.jwtService = jwtService;
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<Object> register(@RequestBody RegisterUserDto input) throws Exception{
        User user = authService.signup(input);
        if(user == null){
            return new ResponseEntity<>("User already exists", HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResp> login(@RequestBody LoginUserDto input){
        User user = authService.authenticate(input);
        log.info("User authenticated: " + user.getEmail());
        String token = jwtService.generateToken(user);

        LoginResp loginResponse = new LoginResp();
        loginResponse.setToken(token);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }
}
