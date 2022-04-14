package com.example.springboot.mobileappws.ui.controller;

import com.example.springboot.mobileappws.ui.model.request.UserDetailsRequestBody;
import com.example.springboot.mobileappws.ui.model.response.UserRest;
import org.springframework.web.bind.annotation.*;

@RestController // With this the class is able to receive HttpRequests.
@RequestMapping(path = "users") // http://localhost:8080/users // A controller for getting path in the URLs
public class UserController {
    // Controls all operations that can be performed on the user.

    @GetMapping // maps the get request to this function.
    public String getUser() {
        return "get User was Called";
    }

    @PostMapping // maps to http POST request.
    public UserRest createUser(@RequestBody UserDetailsRequestBody userDetails) {
        return null;
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
