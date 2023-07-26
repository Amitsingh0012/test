package com.amit.Expense.Tracker.repository;

import com.amit.Expense.Tracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User findFirstByUserEmail(String newEmail);
}

