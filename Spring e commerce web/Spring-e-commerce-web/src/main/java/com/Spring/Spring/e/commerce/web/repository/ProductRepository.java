package com.Spring.Spring.e.commerce.web.repository;

import com.Spring.Spring.e.commerce.web.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findByCategory(String category);
}
