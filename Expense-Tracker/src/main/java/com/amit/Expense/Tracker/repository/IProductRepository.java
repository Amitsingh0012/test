package com.amit.Expense.Tracker.repository;

import com.amit.Expense.Tracker.model.Product;
import com.amit.Expense.Tracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product,Long> {
    List<Product> findByUserAndDateBetween(User user, LocalDate startDate, LocalDate endDate);
}
