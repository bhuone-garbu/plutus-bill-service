package com.garbu.plutus.model;

import java.math.BigDecimal;
import java.util.UUID;

public class Expense {

    private final UUID id;
    private String name;
    private BigDecimal amount;
    private User paidByUser;

    public Expense(UUID id, String name, BigDecimal amount, User paidByUser) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.paidByUser = paidByUser;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public User getPaidByUser() {
        return paidByUser;
    }
}
