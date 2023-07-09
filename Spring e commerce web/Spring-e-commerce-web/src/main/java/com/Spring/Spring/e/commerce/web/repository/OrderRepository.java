package com.Spring.Spring.e.commerce.web.repository;

import com.Spring.Spring.e.commerce.web.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {

}
