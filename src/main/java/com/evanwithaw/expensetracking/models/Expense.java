package com.evanwithaw.expensetracking.models;


import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Expense {

    @Id
    private String expenseId;
    private String userId;
    private String description;
    private BigDecimal amount;
    private LocalDate addedDate;
    private String frequency;


    public LocalDate getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(LocalDate addedDate) {
        this.addedDate = addedDate;
    }

    public String getId() {
        return expenseId;
    }

    public void setId(String id) {
        this.expenseId = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(String expenseId) {
        this.expenseId = expenseId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
