package com.example.awesomespringjpa.repository;

import com.example.awesomespringjpa.models.Channel;
import com.example.awesomespringjpa.models.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriberRepository extends JpaRepository<Subscriber, Integer> {
}
