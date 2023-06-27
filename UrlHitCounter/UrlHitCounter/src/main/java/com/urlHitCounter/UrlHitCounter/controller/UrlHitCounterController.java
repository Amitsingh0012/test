package com.urlHitCounter.UrlHitCounter.controller;

import com.urlHitCounter.UrlHitCounter.Entity.User;
import com.urlHitCounter.UrlHitCounter.Service.UrlHitCounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("api/v1/visitor-count-app")
@RestController
public class UrlHitCounterController {
    @Autowired
    UrlHitCounterService urlHitCounterService;

    @GetMapping("users")
    List<User> getAllUser(){
        return urlHitCounterService.getAllUser();
    }
    @GetMapping("count")
    String getHitCount(){
        return "Visitors :"+ urlHitCounterService.getCount();
    }
    @GetMapping("username/{username}/count")
    String getUserHitCount(@PathVariable String username){
        return "username :"+username+"\n"+"count :" + urlHitCounterService.getUserCount(username);
    }
}
