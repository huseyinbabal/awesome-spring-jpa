package com.example.awesomespringjpa.repository;

import com.example.awesomespringjpa.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
