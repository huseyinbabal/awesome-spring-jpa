package com.example.awesomespringjpa.repository;

import com.example.awesomespringjpa.models.CartItem;
import com.example.awesomespringjpa.models.Channel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChannelRepository extends JpaRepository<Channel, Integer> {
}
