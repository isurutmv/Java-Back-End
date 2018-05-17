package com.example.java_back.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.java_back.Domain.User;

public interface UserRepository extends CrudRepository<User, Long>{
    User findByUsername(String username);
    User findByEmail(String email);
    List<User> findAll();
}