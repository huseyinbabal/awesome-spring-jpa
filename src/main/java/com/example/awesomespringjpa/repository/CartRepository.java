package com.example.awesomespringjpa.repository;

import com.example.awesomespringjpa.models.Cart;
import com.example.awesomespringjpa.models.Passport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Integer> {
    List<Cart> findByUserId(Integer userId);
}
