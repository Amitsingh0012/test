package com.urlHitCounter.UrlHitCounter.configuration;

import com.urlHitCounter.UrlHitCounter.Entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class BeanFactory {
    @Bean

    public List<User> getInializedUser(){
        User inituser=new User("Amit",0);
        List<User> originalUser=new ArrayList<>();
        originalUser.add(inituser);
        return originalUser;
    }
}
