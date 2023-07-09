package com.Spring.Spring.e.commerce.web.controller;

import com.Spring.Spring.e.commerce.web.model.User;
import com.Spring.Spring.e.commerce.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("user")
    public void createUser(@RequestBody User user){
        userService.createUser(user);
    }

    @GetMapping("user/{id}")
    public Optional<User> getUserById(@PathVariable Integer id){
        return userService.getUserById(id);
    }

}