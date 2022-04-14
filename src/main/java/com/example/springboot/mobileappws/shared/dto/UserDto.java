package com.example.springboot.mobileappws.shared.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Setter
public class UserDto implements Serializable {

    @Serial
    private static final long serialVersionUID  = 8771218560377097616L;

    @Getter
    private long id;

    @Getter
    private String userId;

    @Getter
    private String firstName;

    @Getter
    private String lastName;

    @Getter
    private String email;

    @Getter
    private String password;

    @Getter
    private String encryptedPassword;

    @Getter
    private boolean emailVerificationStatus;

}
