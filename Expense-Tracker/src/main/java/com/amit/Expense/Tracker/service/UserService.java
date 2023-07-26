package com.amit.Expense.Tracker.service;

import com.amit.Expense.Tracker.model.AuthenticationToken;
import com.amit.Expense.Tracker.model.Product;
import com.amit.Expense.Tracker.model.User;
import com.amit.Expense.Tracker.model.dto.SignInInput;
import com.amit.Expense.Tracker.model.dto.SignUpOutput;
import com.amit.Expense.Tracker.repository.IProductRepository;
import com.amit.Expense.Tracker.repository.UserRepository;
import com.amit.Expense.Tracker.service.HashingUtility.PasswordEcrypter;
import com.amit.Expense.Tracker.service.email.EmailHandler;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserService {
   @Autowired
    UserRepository userRepository;
   @Autowired
   AuthenticationService authenticationService;
   @Autowired
    IProductRepository productRepository;

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    public SignUpOutput signUpUser(User user) {

        boolean signUpStatus = true;
        String signUpStatusMessage = null;

        String newEmail = user.getUserEmail();

        if(newEmail == null)
        {
            signUpStatusMessage = "Invalid email";
            signUpStatus = false;
            return new SignUpOutput(signUpStatus,signUpStatusMessage);
        }

        //check if this user email already exists ??
        User existingUser = userRepository.findFirstByUserEmail(newEmail);

        if(existingUser != null)
        {
            signUpStatusMessage = "Email already registered!!!";
            signUpStatus = false;
            return new SignUpOutput(signUpStatus,signUpStatusMessage);
        }

        //hash the password: encrypt the password
        try {
            String encryptedPassword = PasswordEcrypter.encryptPassword(user.getUserpassword());

            //saveAppointment the user with the new encrypted password

            user.setUserpassword(encryptedPassword);
            userRepository.save(user);

            return new SignUpOutput(signUpStatus, "User registered successfully!!!");
        }
        catch(Exception e)
        {
            signUpStatusMessage = "Internal error occurred during sign up";
            signUpStatus = false;
            return new SignUpOutput(signUpStatus,signUpStatusMessage);
        }
    }

    public String signInUser(@Valid SignInInput signInInput) {


        String signInStatusMessage = null;

        String signInEmail = signInInput.getEmail();

        if(signInEmail == null)
        {
            signInStatusMessage = "Invalid email";
            return signInStatusMessage;


        }

        //check if this user email already exists ??
        User existingUser = userRepository.findFirstByUserEmail(signInEmail);

        if(existingUser == null)
        {
            signInStatusMessage = "Email not registered!!!";
            return signInStatusMessage;

        }

        //match passwords :

        //hash the password: encrypt the password
        try {
            String encryptedPassword = PasswordEcrypter.encryptPassword(signInInput.getPassword());
            if(existingUser.getUserpassword().equals(encryptedPassword))
            {
                //session should be created since password matched and user id is valid
                AuthenticationToken authToken  = new AuthenticationToken(existingUser);
                authenticationService.saveAuthToken(authToken);

                EmailHandler.sendEmail("mainakgh1@gmail.com","email testing",authToken.getTokenValue());
                return "Token sent to your email";
            }
            else {
                signInStatusMessage = "Invalid credentials!!!";
                return signInStatusMessage;
            }
        }
        catch(Exception e)
        {
            signInStatusMessage = "Internal error occurred during sign in";
            return signInStatusMessage;
        }

    }

    public String sigOutUser(String email) {

        User user = userRepository.findFirstByUserEmail(email);
        AuthenticationToken token = authenticationService.findFirstByUser(user);
        authenticationService.removeToken(token);
        return "User Signed out successfully";
    }

    public String addProduct(Product product) {
        productRepository.save(product);
        return "product Added successfully";
    }

    public String removeProduct(Long id) {
        productRepository.delete(productRepository.getReferenceById(id));
        return "user removed "+productRepository.findById(id);
    }

    public double getTotalExpenditureForMonth(User user, int month, int year) {
        LocalDate startDate = LocalDate.of(year, month, 1);
        LocalDate endDate = startDate.plusMonths(1).minusDays(1);
        List<Product> products = productRepository.findByUserAndDateBetween(user, startDate, endDate);
        return products.stream().mapToDouble(Product::getPrice).sum();
    }
}
