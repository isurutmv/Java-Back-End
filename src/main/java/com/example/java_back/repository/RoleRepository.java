package com.example.java_back.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.java_back.Domain.security.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {

}