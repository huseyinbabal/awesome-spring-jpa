package com.example.awesomespringjpa.repository;

import com.example.awesomespringjpa.models.Passport;
import com.example.awesomespringjpa.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassportRepository extends JpaRepository<Passport, Integer> {
}
