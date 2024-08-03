package com.evanwithaw.expensetracking.repository;

import com.evanwithaw.expensetracking.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, Integer> {
    public User findByUserId(Integer id);
    public List<User> findAll();
    public void deleteById(Integer id);
    public User findByEmail(String email);
}
