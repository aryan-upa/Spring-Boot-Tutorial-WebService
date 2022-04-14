package com.example.springboot.mobileappws.ui.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // With this the class is able to receive HttpRequests.
@RequestMapping(path = "users") // http://localhost:8080/users // A controller for getting path in the URLs
public class UserController {
    // Controls all operations that can be performed on the user.

}
