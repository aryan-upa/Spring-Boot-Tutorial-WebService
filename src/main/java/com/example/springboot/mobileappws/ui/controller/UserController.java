package com.example.springboot.mobileappws.ui.controller;

import com.example.springboot.mobileappws.service.UserService;
import com.example.springboot.mobileappws.shared.dto.UserDto;
import com.example.springboot.mobileappws.ui.model.request.UserDetailsRequestBody;
import com.example.springboot.mobileappws.ui.model.response.UserRest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController // With this the class is able to receive HttpRequests.
@RequestMapping(path = "users") // http://localhost:8080/users // A controller for getting path in the URLs
public class UserController {
    // Controls all operations that can be performed on the user.

    @Autowired
    UserService userService;

    @GetMapping // maps the get request to this function.
    public String getUser() {
        return "get User was Called";
    }

    @PostMapping // maps to http POST request.
    public UserRest createUser(@RequestBody UserDetailsRequestBody userDetails) {
        UserRest returnValue = new UserRest();

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetails, userDto);

        UserDto createdUser = userService.createUser(userDto);
        BeanUtils.copyProperties(createdUser, returnValue);

        return returnValue;
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
