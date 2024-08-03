package com.evanwithaw.expensetracking.repository;

import com.evanwithaw.expensetracking.models.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ExpenseRepository extends MongoRepository<Expense, Long> {

    public Expense findByExpenseId(Long id);
    public List<Expense> findAll();
    public Expense save(Expense expense);
    public void deleteById(Long id);
}
