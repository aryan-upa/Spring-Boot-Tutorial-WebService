package com.example.springboot.mobileappws.shared.dto;

import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Setter
public class UserDto implements Serializable {

    @Serial
    private static final long serialVersionUID  = 8771218560377097616L;

    private long id;
    private String userId;
    private String fName;
    private String lName;
    private String email;
    private String password;
    private String encryptedPassword;
    private String emailVerificationStatus;

    public String getUserId() {
        return userId;
    }

    public String getFirstName() {
        return fName;
    }

    public String getLastName() {
        return lName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public String getEmailVerificationStatus() {
        return emailVerificationStatus;
    }
}
