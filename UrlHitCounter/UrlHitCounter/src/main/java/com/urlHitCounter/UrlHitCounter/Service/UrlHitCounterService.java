package com.urlHitCounter.UrlHitCounter.Service;

import com.urlHitCounter.UrlHitCounter.Entity.User;
import com.urlHitCounter.UrlHitCounter.repository.UrlHitCounterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UrlHitCounterService {
    @Autowired
    UrlHitCounterRepo urlHitCounterRepo;
    private int hitCount=0;

    public List<User> getAllUser() {
        return urlHitCounterRepo.getListUser();
    }

    public int getCount() {
        hitCount+=1;
        return hitCount;
    }

    public int getUserCount(String username) {

        List<User> alloriginallist=getAllUser();
        for (User alluser:alloriginallist){
            if(alluser.getName().equals(username)){
                alluser.setCount(alluser.getCount()+1);
                return alluser.getCount();
            }
        }
        return 0;
    }
}
