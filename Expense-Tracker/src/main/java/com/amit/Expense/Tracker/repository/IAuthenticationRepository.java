package com.amit.Expense.Tracker.repository;

import com.amit.Expense.Tracker.model.AuthenticationToken;
import com.amit.Expense.Tracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface IAuthenticationRepository extends JpaRepository<AuthenticationToken,Long> {


    AuthenticationToken findFirstByTokenValue(String authTokenValue);

    AuthenticationToken findFirstByUser(User user);
}
