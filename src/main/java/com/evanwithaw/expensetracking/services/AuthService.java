package com.evanwithaw.expensetracking.services;

import com.evanwithaw.expensetracking.dtos.LoginUserDto;
import com.evanwithaw.expensetracking.dtos.RegisterUserDto;
import com.evanwithaw.expensetracking.models.User;
import com.evanwithaw.expensetracking.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authManager;

    public AuthService(
            UserRepository userRepository,
            AuthenticationManager authManager,
            PasswordEncoder passwordEncoder
    ){
        this.userRepository = userRepository;
        this.authManager = authManager;
        this.passwordEncoder = passwordEncoder;
    }

    public User signup(RegisterUserDto input){
        User user = new User();
        if(userRepository.existsByEmail(input.getEmail())){
            return null;
        }

        user.setEmail(input.getEmail());
        user.setFirstName(input.getFirstName());
        user.setLastName(input.getLastName());
        user.setPassword(passwordEncoder.encode(input.getPassword()));

        return userRepository.save(user);
    }

    public User authenticate(LoginUserDto input){
        authManager.authenticate(new UsernamePasswordAuthenticationToken(input.getEmail(), input.getPassword()));

        return userRepository.findByEmail(input.getEmail());
    }


}
