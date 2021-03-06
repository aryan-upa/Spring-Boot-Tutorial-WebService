package com.example.springboot.mobileappws.ui.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDetailsRequestBody {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
