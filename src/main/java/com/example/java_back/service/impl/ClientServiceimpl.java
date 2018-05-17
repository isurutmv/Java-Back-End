package com.example.java_back.service.impl;

import com.example.java_back.Domain.Client;
import com.example.java_back.repository.ClientRepository;
import com.example.java_back.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceimpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> findAll() {
        List<Client> clientList = (List<Client>) clientRepository.findAll();
        return clientList;
    }

    @Override
    public Client findOne(Long id) {
        return clientRepository.findOne(id);
    }

    @Override
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void removeOne(Long id) {
      clientRepository.delete(id);
    }
}
