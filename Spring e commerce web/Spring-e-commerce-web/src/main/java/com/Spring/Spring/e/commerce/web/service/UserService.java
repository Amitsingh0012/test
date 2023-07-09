package com.Spring.Spring.e.commerce.web.service;

import com.Spring.Spring.e.commerce.web.model.User;
import com.Spring.Spring.e.commerce.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void createUser(User user) {
        userRepository.save(user);
    }

    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }
}
