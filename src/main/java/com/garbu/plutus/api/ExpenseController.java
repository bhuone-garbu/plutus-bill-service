package com.garbu.plutus.api;

import com.garbu.plutus.model.Expense;
import com.garbu.plutus.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.UUID;

@RestController
public class ExpenseController {

    @GetMapping("/expenses")
    public Expense getExpense(@RequestParam(value = "id", required = false) String id) {
        User testUser = new User(UUID.randomUUID(), "John", "Doe", "something@gmail.com", "07123456789");
        return new Expense(UUID.randomUUID(), "this is a test", new BigDecimal("2.3"), testUser);
    }
}
