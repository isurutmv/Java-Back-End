package com.example.java_back.service;

import com.example.java_back.Domain.Client;

import java.util.List;

public interface ClientService {

    List<Client> findAll();
    Client findOne(Long id);
    Client save(Client client);

    void removeOne(Long id);
}
