package com.garbu.plutus.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class Split {

  private final UUID id;

  private Bill bill;
  private BigDecimal amount;
  private User recipient;
  private Boolean isPaid = false;

  public Split(UUID id, Bill bill, User recipient) {
    this.id = id;
    this.bill = bill;
    this.recipient = recipient;
  }
}
