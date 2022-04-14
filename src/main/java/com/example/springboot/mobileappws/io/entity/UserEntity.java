package com.example.springboot.mobileappws.io.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serial;
import java.io.Serializable;

@Setter
@Entity(name = "Users")
public class UserEntity implements Serializable {

    @Serial
    private static final long serialVersionUID  = 8771218560377097616L;

    @Getter
    @Id
    @GeneratedValue
    private long id;

    @Getter
    @Column(nullable = false)
    private String userId;

    @Getter
    @Column(length = 50)
    private String fName;

    @Getter
    @Column(length = 50)
    private String lName;

    @Getter
    @Column(length = 100)
    private String email;

    @Getter
    @Column(nullable = false)
    private String encryptedPassword;

    @Getter
    private String emailVerificationToken;

    @Getter
    @Column(nullable = false)
    private boolean emailVerificationStatus = false;
    
}
