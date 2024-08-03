package com.evanwithaw.expensetracking.repository;

import com.evanwithaw.expensetracking.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String>
{
    public User findByUsername(String username);
    public User findByEmail(String email);
    public User findByUsernameOrEmail(String username, String email);
    public User save(User user);
}
