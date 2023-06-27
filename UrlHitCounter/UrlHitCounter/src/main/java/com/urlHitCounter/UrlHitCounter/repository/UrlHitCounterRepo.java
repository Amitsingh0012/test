package com.urlHitCounter.UrlHitCounter.repository;

import com.urlHitCounter.UrlHitCounter.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UrlHitCounterRepo {
    @Autowired
    private List<User> listuser;
    public List<User> getListUser(){
        return listuser;
    }

}
