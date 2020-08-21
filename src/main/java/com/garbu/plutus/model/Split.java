package com.garbu.plutus.model;

import java.util.UUID;

public class Split {

    private final UUID id;

    private Expense expense;

    public enum SplitType {
        EQUAL,
        UNEQUAL;
    }

    public Split(UUID id, Expense expense) {
        this.id = id;
        this.expense = expense;
    }

    public UUID getId() {
        return id;
    }

    public Expense getExpense() {
        return expense;
    }
}
