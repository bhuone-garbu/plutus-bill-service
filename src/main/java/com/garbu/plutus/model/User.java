package com.garbu.plutus.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
public class User {

  @Id
  @GeneratedValue
  @Column(name = "id", updatable = false, nullable = false)
  private final UUID id;

  @Column(name = "username", nullable = false, unique = true)
  private String username;

  @Column(name = "email", nullable = false, unique = true)
  private String email;

  @Column(name = "mobile_no", nullable = false, unique = true)
  private String mobileNo;

  @Column(name = "registered_at", nullable = false)
  private LocalDateTime registeredAt;

  @Column(name = "updated_at", nullable = false)
  private LocalDateTime updatedAt;

  public User(String id, String username, String email, String mobileNo) {
    this.id = UUID.fromString(id);
    this.username = username;
    this.email = email;
    this.mobileNo = mobileNo;
  }
}
