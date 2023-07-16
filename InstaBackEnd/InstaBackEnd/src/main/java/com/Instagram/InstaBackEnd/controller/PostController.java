package com.Instagram.InstaBackEnd.controller;

import com.Instagram.InstaBackEnd.model.Post;
import com.Instagram.InstaBackEnd.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
public class PostController {
    @Autowired
    PostService postService;

    @PostMapping("user/post")
    public String createPost(@RequestBody Post post){
        return postService.createInstaPost(post);
    }
    @GetMapping("user/getpost")
    public  Post getPost(@RequestParam Long postId){
        return postService.getPostById(postId);
    }

}
