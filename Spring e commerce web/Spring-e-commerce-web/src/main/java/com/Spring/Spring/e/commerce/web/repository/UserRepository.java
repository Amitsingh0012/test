package com.Spring.Spring.e.commerce.web.repository;

import com.Spring.Spring.e.commerce.web.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
