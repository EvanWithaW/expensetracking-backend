package com.evanwithaw.expensetracking.services;

import com.evanwithaw.expensetracking.models.User;
import com.evanwithaw.expensetracking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;

    public String getName(String token){
        User usr = userRepository.findByEmail(jwtService.extractUsername(token));
        return usr.getFirstName() + " " + usr.getLastName();
    }

}
