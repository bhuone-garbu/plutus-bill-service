package com.garbu.plutus.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
public class Expense {

    private final UUID id;
    private String description;
    private BigDecimal amount;
    private User paidByUser;

//    public Expense(UUID id, String description, BigDecimal amount, User paidByUser) {
//        this.id = id;
//        this.description = description;
//        this.amount = amount;
//        this.paidByUser = paidByUser;
//    }

}
