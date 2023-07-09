package com.Spring.Spring.e.commerce.web.controller;

import com.Spring.Spring.e.commerce.web.model.Address;
import com.Spring.Spring.e.commerce.web.model.Order;
import com.Spring.Spring.e.commerce.web.model.Product;
import com.Spring.Spring.e.commerce.web.model.User;
import com.Spring.Spring.e.commerce.web.repository.AddressRepository;
import com.Spring.Spring.e.commerce.web.repository.OrderRepository;
import com.Spring.Spring.e.commerce.web.repository.ProductRepository;
import com.Spring.Spring.e.commerce.web.repository.UserRepository;
import com.Spring.Spring.e.commerce.web.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OderController {
    @Autowired
    OrderService orderService;

    @PostMapping("order")
    public void createOrder(@RequestBody Order order){
        orderService.createOrder(order);
    }

    @GetMapping("order/{id}")
    public Optional<Order> getOrderById(@PathVariable Integer id){
        return orderService.getOrderById(id);
    }
}


