package com.example.springboot.mobileappws.service;

import com.example.springboot.mobileappws.shared.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    UserDto createUser(UserDto user);

    UserDto getUser(String email);
}
