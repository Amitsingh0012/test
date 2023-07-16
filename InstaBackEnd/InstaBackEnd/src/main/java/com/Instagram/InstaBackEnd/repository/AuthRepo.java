package com.Instagram.InstaBackEnd.repository;

import com.Instagram.InstaBackEnd.model.AuthenticationToken;
import com.Instagram.InstaBackEnd.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepo extends JpaRepository<AuthenticationToken,Long> {
    AuthenticationToken findFirstByUser(User user);

    AuthenticationToken findFirstByToken(String authTokenValue);
}
