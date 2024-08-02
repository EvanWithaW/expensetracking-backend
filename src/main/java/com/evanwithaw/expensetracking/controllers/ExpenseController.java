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

    @GetMapping("/")
    public void index(Model model){
        List<Expense> expenses = expenseService.getAllExpenses();
        model.addAttribute("expensetest1", expenses);
    }

    @PostMapping("/addExpense")
    @ResponseBody
    public ResponseEntity<String> addExpense(@RequestBody Expense expense){
        expense.setAddedDate(java.time.LocalDate.now());
        expenseService.saveExpense(expense);
        return ResponseEntity.ok("Expense added successfully");
    }

    @GetMapping("/getExpenses")
    @ResponseBody
    public List<Expense> getExpenses(){
        return expenseService.getAllExpenses();
    }


    @GetMapping("/deleteExpense/{id}")
    public String deleteExpense(@PathVariable Long id){
        expenseService.deleteExpense(id);
        return "redirect:/";
    }

}
