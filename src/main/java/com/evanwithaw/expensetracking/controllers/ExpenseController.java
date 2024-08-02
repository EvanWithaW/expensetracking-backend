package com.evanwithaw.expensetracking.controllers;

import com.evanwithaw.expensetracking.models.Expense;
import com.evanwithaw.expensetracking.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @PostMapping("/addExpense")
    @ResponseBody
    public ResponseEntity<String> addExpense(@RequestBody Expense expense){
        expense.setAddedDate(java.time.LocalDate.now());
        expenseService.saveExpense(expense);
        // TODO: remove this later on, just return code
        return ResponseEntity.ok("Expense added successfully");
    }

    @GetMapping("/getExpenses")
    @ResponseBody
    public List<Expense> getExpenses(){
        return expenseService.getAllExpenses();
    }


    @GetMapping("/deleteExpense/{id}")
    public void deleteExpense(@PathVariable Long id){
        expenseService.deleteExpense(id);
        // TODO: explore how best to deleteExpenses
    }

}
