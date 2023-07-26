package com.amit.Expense.Tracker.controller;

import com.amit.Expense.Tracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {
    @Autowired
    ExpenseService expenseService;

}

