package com.garbu.plutus.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class AppUser {

  private final UUID id;
  private String username;
  private String email;
  private String mobileNo;

  private LocalDateTime registeredAt;
  private LocalDateTime updatedAt;

  public AppUser(String id, String username, String email, String mobileNo) {
    this.id = UUID.fromString(id);
    this.username = username;
    this.email = email;
    this.mobileNo = mobileNo;
  }
}
