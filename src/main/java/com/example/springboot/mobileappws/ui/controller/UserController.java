package com.example.springboot.mobileappws.ui.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // With this the class is able to receive HttpRequests.
@RequestMapping(path = "users") // http://localhost:8080/users // A controller for getting path in the URLs
public class UserController {
    // Controls all operations that can be performed on the user.

    @GetMapping // maps the get request to this function.
    public String getUser() {
        return "get User was Called";
    }

    @PostMapping // maps to http POST request.
    public String createUser() {
        return "create User was Called";
    }

    @PutMapping
    public String updateUser() {
        return "update user was Called";
    }

    @DeleteMapping
    public String deleteUser() {
        return "delete user was Called";
    }
}
