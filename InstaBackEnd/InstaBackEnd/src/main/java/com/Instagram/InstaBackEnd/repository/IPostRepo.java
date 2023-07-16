package com.Instagram.InstaBackEnd.repository;

import com.Instagram.InstaBackEnd.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPostRepo extends JpaRepository<Post,Long> {
}
