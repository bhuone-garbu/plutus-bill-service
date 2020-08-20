package com.garbu.plutus.model;

import java.util.UUID;

public class Expense {

    private final UUID id;
    private final String name;

    public Expense(UUID id, String name) {
        this.id = id;
        this.name = name;
    }
}
