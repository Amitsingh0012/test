package com.Instagram.InstaBackEnd.service;

import com.Instagram.InstaBackEnd.model.AuthenticationToken;
import com.Instagram.InstaBackEnd.model.User;
import com.Instagram.InstaBackEnd.repository.AuthRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    AuthRepo authRepo;
    public boolean authenticate(String email, String authTokenValue)
    {
        AuthenticationToken authToken = authRepo.findFirstByToken(authTokenValue);

        if(authToken == null)
        {
            return false;
        }

        String tokenConnectedEmail = authToken.getUser().getEmail();

        return tokenConnectedEmail.equals(email);
    }

    public void saveAuthToken(AuthenticationToken authToken)
    {
        authRepo.save(authToken);
    }

    public AuthenticationToken findFirstByUser(User user) {
        return authRepo.findFirstByUser(user);
    }

    public void removeToken(AuthenticationToken token) {
        authRepo.delete(token);
    }
}
