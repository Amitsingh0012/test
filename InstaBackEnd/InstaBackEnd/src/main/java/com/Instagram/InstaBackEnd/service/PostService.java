package com.Instagram.InstaBackEnd.service;

import com.Instagram.InstaBackEnd.model.Post;
import com.Instagram.InstaBackEnd.model.User;
import com.Instagram.InstaBackEnd.repository.IPostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class PostService {
    @Autowired
    IPostRepo postRepo;
    public String createInstaPost(Post post) {
        post.setCreatedDate(LocalDate.now());
        postRepo.save(post);
        return "Post uploaded!!!!";
    }


    public Post getPostById(Long postId) {
        return postRepo.getReferenceById(postId);
    }
}
