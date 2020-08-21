package com.garbu.plutus.model;

import java.math.BigDecimal;
import java.util.UUID;

public class Expense {

    private final UUID id;
    private String description;
    private BigDecimal amount;
    private User paidByUser;

    public Expense(UUID id, String description, BigDecimal amount, User paidByUser) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.paidByUser = paidByUser;
    }

    public UUID getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public User getPaidByUser() {
        return paidByUser;
    }
}
