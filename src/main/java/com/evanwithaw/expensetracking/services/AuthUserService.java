package com.evanwithaw.expensetracking.services;

import com.evanwithaw.expensetracking.models.User;
import com.evanwithaw.expensetracking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthUserService {

    @Autowired
    private UserRepository userRepository;


    public User registerUser(User user) {
        return userRepository.save(user);
    }
}
