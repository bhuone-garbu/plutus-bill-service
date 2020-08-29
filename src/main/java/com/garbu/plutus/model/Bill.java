package com.garbu.plutus.model;

// import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class Bill {

  private final UUID id;

  @NotBlank private String description;

  @NotNull private BigDecimal amount;
  private AppUser paidByAppUser;

  @Builder.Default() private Boolean isPaid = false;

  @Builder.Default() private Boolean isDeleted = false;

  private LocalDateTime billCreatedAt;
  private LocalDateTime billUpdatedAt;

  public Bill(
      String id,
      String description,
      BigDecimal amount,
      AppUser paidByAppUser,
      Boolean isPaid,
      Boolean isDeleted,
      LocalDateTime billCreatedAt,
      LocalDateTime billUpdatedAt) {

    this.id = UUID.fromString(id);
    this.description = description;
    this.amount = amount;
    this.paidByAppUser = paidByAppUser;
    this.isPaid = isPaid;
    this.isDeleted = isDeleted;
    this.billCreatedAt = billCreatedAt;
    this.billUpdatedAt = billUpdatedAt;
  }
}
