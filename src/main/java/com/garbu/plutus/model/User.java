package com.garbu.plutus.model;

import java.util.UUID;

public class User {

    private final UUID id;

    private String firstName;
    private String lastName;
    private String email;
    private String mobileNo;

    public User(UUID id, String firstName, String lastName, String email, String mobileNo) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobileNo = mobileNo;
    }

    public UUID getId() {
        return id;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }
}
