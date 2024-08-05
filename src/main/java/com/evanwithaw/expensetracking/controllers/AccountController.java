package com.evanwithaw.expensetracking.controllers;

import com.evanwithaw.expensetracking.dtos.UserInfoDto;
import com.evanwithaw.expensetracking.services.AccountService;
import com.evanwithaw.expensetracking.services.JwtService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Object> getUserInfo(@RequestHeader("Authorization") String authorizationHeader){
        String token = jwtService.extractTokenFromHeader(authorizationHeader);
        return ResponseEntity.ok(new UserInfoDto(accountService.getName(token)));
    }
}
