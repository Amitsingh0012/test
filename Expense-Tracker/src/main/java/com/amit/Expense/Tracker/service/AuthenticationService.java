package com.amit.Expense.Tracker.service;

import com.amit.Expense.Tracker.model.AuthenticationToken;
import com.amit.Expense.Tracker.model.User;
import com.amit.Expense.Tracker.repository.IAuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    IAuthenticationRepository authenticationRepo;
    public boolean authenticate(String email, String authTokenValue)
    {
        AuthenticationToken authToken = authenticationRepo.findFirstByTokenValue(authTokenValue);

        if(authToken == null)
        {
            return false;
        }

        String tokenConnectedEmail = authToken.getUser().getUserEmail();

        return tokenConnectedEmail.equals(email);
    }

    public void saveAuthToken(AuthenticationToken authToken)
    {
        authenticationRepo.save(authToken);
    }

    public AuthenticationToken findFirstByUser(User user) {
        return authenticationRepo.findFirstByUser(user);
    }

    public void removeToken(AuthenticationToken token) {
        authenticationRepo.delete(token);
    }
}
