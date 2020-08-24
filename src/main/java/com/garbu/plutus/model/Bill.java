package com.garbu.plutus.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class Bill {

  private final UUID id;
  private String description;
  private BigDecimal amount;
  private User paidByUser;
  private Boolean isPaid = false;

  private LocalDateTime billCreatedAt;
  private LocalDateTime billUpdatedAt;
}
