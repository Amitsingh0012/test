package com.amit.Expense.Tracker.controller;

import com.amit.Expense.Tracker.model.Product;
import com.amit.Expense.Tracker.model.User;
import com.amit.Expense.Tracker.model.dto.SignInInput;
import com.amit.Expense.Tracker.model.dto.SignUpOutput;
import com.amit.Expense.Tracker.service.AuthenticationService;
import com.amit.Expense.Tracker.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    AuthenticationService authenticationService;
    @PostMapping("user/signup")
    public SignUpOutput signUpUser(@RequestBody User user)
    {
        return userService.signUpUser(user);
    }
    @PostMapping("user/signIn")
    public String sigInUser(@RequestBody @Valid SignInInput signInInput)
    {
        return userService.signInUser(signInInput);
    }
    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User newUser = userService.registerUser(user);
        return ResponseEntity.ok(newUser);
    }
    @DeleteMapping("user/signOut")
    public String sigOutUser(String email, String token)
    {
        if(authenticationService.authenticate(email,token)) {
            return userService.sigOutUser(email);
        }
        else {
            return "Sign out not allowed for non authenticated user.";
        }

    }
    @PostMapping("product")
    public String addComment(@RequestBody Product product, @RequestParam String userEmail, @RequestParam String userToken)
    {
        if(authenticationService.authenticate(userEmail,userToken)) {
            return userService.addProduct(product);
        }
        else {
            return "Not an Authenticated user activity!!!";
        }
    }


    @DeleteMapping("comment")
    public String removeProduct(@RequestParam Long commentId, @RequestParam String email, @RequestParam String token)
    {
        if(authenticationService.authenticate(email,token)) {
            return userService.removeProduct(commentId);
        }
        else {
            return "Not an Authenticated user activity!!!";
        }
    }
    @GetMapping("/expenditure")
    public ResponseEntity<Double> getTotalExpenditureForMonth(@RequestParam int month, @RequestParam int year,@RequestBody User user, @RequestParam String email,@RequestParam String token) {
        double totalExpenditure=0.0;
        if(authenticationService.authenticate(email,token)) {
            totalExpenditure = userService.getTotalExpenditureForMonth(user, month, year);
            return ResponseEntity.ok(totalExpenditure);
        }
        return ResponseEntity.ok(totalExpenditure);
    }
}
