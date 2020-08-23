package com.garbu.plutus.api;

import com.garbu.plutus.model.Expense;
import com.garbu.plutus.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class ExpenseController {

    private static List<Expense> expenses = new ArrayList<>();
    private static User testUser = new User(UUID.randomUUID(), "John", "Doe",
            "something@gmail.com", "07123456789");

    static {
        Expense expense = Expense.builder()
                .id(UUID.randomUUID())
                .amount(new BigDecimal("2.3"))
                .description("this is a test")
                .paidByUser(testUser).build();
        expenses.add(expense);
        //expenses.add(new Expense(UUID.randomUUID(), "this is a test", new BigDecimal("2.3"), testUser));
    }

    @GetMapping("/expenses")
    public List<Expense> getAll(@RequestParam(value = "amount", required = false) String amount) {
        return expenses;
    }

    @GetMapping("expenses/{id}")
    public Expense getOne(@PathVariable String id) {
        // TODO: Service method to get an expense from the id
        return expenses.get(0);
    }
}
