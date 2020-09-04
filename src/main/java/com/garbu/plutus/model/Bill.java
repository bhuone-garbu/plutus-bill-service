package com.garbu.plutus.model;

// import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "bill")
public class Bill {

  @Id
  @Column(name = "id", updatable = false, nullable = false)
  private final Long id;

  @NotBlank
  @Column(name = "description", nullable = false)
  private String description;

  @NotNull
  @Column(name = "amount", nullable = false)
  private BigDecimal amount;

  @NotNull
  @ManyToOne
  @JoinColumn(name = "created_by", referencedColumnName = "id")
  private User createdBy;

  @NotNull
  @ManyToOne
  @JoinColumn(name = "paid_by", referencedColumnName = "id")
  private User paidBy;

  @Column(name = "is_paid")
  private Boolean isPaid = false;

  @Column(name = "is_deleted")
  private Boolean isDeleted = false;

  @NotNull
  @Column(name = "bill_created_at",  updatable = false, nullable = false)
  private LocalDateTime billCreatedAt;

  @NotNull
  @Column(name = "bill_updated_at", nullable = false)
  private LocalDateTime billUpdatedAt;

  public Bill(
      String id,
      String description,
      BigDecimal amount,
      User paidBy,
      Boolean isPaid,
      Boolean isDeleted,
      LocalDateTime billCreatedAt,
      LocalDateTime billUpdatedAt) {

    this.id = Long.valueOf(id);
    this.description = description;
    this.amount = amount;
    this.paidBy = paidBy;
    this.isPaid = isPaid;
    this.isDeleted = isDeleted;
    this.billCreatedAt = billCreatedAt;
    this.billUpdatedAt = billUpdatedAt;
  }
}
