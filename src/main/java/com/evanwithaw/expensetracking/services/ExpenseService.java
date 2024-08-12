package com.evanwithaw.expensetracking.services;

import com.evanwithaw.expensetracking.models.Expense;
import com.evanwithaw.expensetracking.models.User;
import com.evanwithaw.expensetracking.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public List<Expense> getAllExpenses() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return expenseRepository.findAllByUserId(user.getUserId());
    }

    public Expense saveExpense(Expense expense) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        expense.setUserId(user.getUserId());
        return expenseRepository.save(expense);
    }

    public void deleteExpense(Long id){
        expenseRepository.deleteById(id);
    }
}
