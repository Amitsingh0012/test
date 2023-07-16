package com.Instagram.InstaBackEnd.controller;

import com.Instagram.InstaBackEnd.model.Post;
import com.Instagram.InstaBackEnd.model.User;
import com.Instagram.InstaBackEnd.model.dto.SignInInput;
import com.Instagram.InstaBackEnd.model.dto.SignUpOutput;
import com.Instagram.InstaBackEnd.service.AuthService;
import com.Instagram.InstaBackEnd.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    AuthService authenticationService;
    @PostMapping("user/signup")
    public SignUpOutput signUpInstaUser(@RequestBody User user)
    {
        return userService.signUpUser(user);
    }
    @PostMapping("user/signIn")
    public String sigInInstaUser(@RequestBody @Valid SignInInput signInInput)
    {
        return userService.signInUser(signInInput);
    }
    @DeleteMapping("user/signOut")
    public String sigOutInstaUser(String email, String token)
    {
        if(authenticationService.authenticate(email,token)) {
            return userService.sigOutUser(email);
        }
        else {
            return "Sign out not allowed for non authenticated user.";
        }

    }
    @PostMapping("post")
    public String createInstaPost(@RequestBody Post post, @RequestParam String email, @RequestParam String token)
    {
        if(authenticationService.authenticate(email,token)) {
            return userService.createInstaPost(post,email);
        }
        else {
            return "Not an Authenticated user activity!!!";
        }
    }
    @PutMapping("User")
    public String updateInstaUser(@RequestBody User user,@RequestParam String email,@RequestParam String fname,@RequestParam String lname,@RequestParam String phoneNumber,@RequestParam String password, @RequestParam String token){
        if(authenticationService.authenticate(email,token)) {
            return userService.updateInstaUser(user,email,fname,lname,phoneNumber,password);
        }
        else {
            return "Not an Authenticated user activity!!!";
        }
    }
}
