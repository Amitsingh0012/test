package com.Spring.Spring.e.commerce.web.service;

import com.Spring.Spring.e.commerce.web.model.Order;
import com.Spring.Spring.e.commerce.web.model.Product;
import com.Spring.Spring.e.commerce.web.repository.OrderRepository;
import com.Spring.Spring.e.commerce.web.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    public void createProduct(Product product) {
        productRepository.save(product);
    }

    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Integer id) {
        return productRepository.findById(id);
    }

    public String deleteProductById(Integer id) {
        productRepository.deleteById(id);
        return "Deleted";
    }
}
