package com.example.java_back.repository;

import com.example.java_back.Domain.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client, Long> {
}
