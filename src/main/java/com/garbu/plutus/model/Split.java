package com.garbu.plutus.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity
public class Split {

  @Id
  @Column(name = "id", updatable = false, nullable = false)
  private final UUID id;

  @NotNull
  @ManyToOne
  @JoinColumn(name = "bill", referencedColumnName = "id")
  private Bill bill;

  @NotNull
  private BigDecimal amount;

  @NotNull
  @ManyToOne
  @JoinColumn(name = "recipient", referencedColumnName = "id")
  private User recipient;
  private Boolean isPaid = false;

  public Split(UUID id, Bill bill, User recipient) {
    this.id = id;
    this.bill = bill;
    this.recipient = recipient;
  }
}
