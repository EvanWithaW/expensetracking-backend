package com.evanwithaw.expensetracking.controllers;

import com.evanwithaw.expensetracking.services.AccountService;
import com.evanwithaw.expensetracking.services.JwtService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class AccountController {

    private final AccountService accountService;
    private final JwtService jwtService;

    public AccountController(AccountService accountService, JwtService jwtService) {
        this.accountService = accountService;
        this.jwtService = jwtService;
    }

    @GetMapping("/info")
    public String getUserInfo(@RequestHeader("Authorization") String authorizationHeader){
        String token = jwtService.extractTokenFromHeader(authorizationHeader);
        return accountService.getName(token);
    }
}
