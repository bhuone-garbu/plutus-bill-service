package com.garbu.plutus.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class User {

  private final UUID id;
  private String username;
  private String email;
  private String mobileNo;

  private LocalDateTime registeredAt;
  private LocalDateTime updatedAt;

  public User(UUID id, String username, String email, String mobileNo) {
    this.id = id;
    this.username = username;
    this.email = email;
    this.mobileNo = mobileNo;
  }
}
