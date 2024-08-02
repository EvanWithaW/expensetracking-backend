package com.evanwithaw.expensetracking.repository;

import com.evanwithaw.expensetracking.models.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
