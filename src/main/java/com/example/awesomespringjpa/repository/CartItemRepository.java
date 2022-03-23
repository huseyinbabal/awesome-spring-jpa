package com.example.awesomespringjpa.repository;

import com.example.awesomespringjpa.models.Cart;
import com.example.awesomespringjpa.models.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
    List<CartItem> findByCart_Id(Integer id);
    Optional<CartItem> findByQuantityGreaterThan(Integer amount);
}
