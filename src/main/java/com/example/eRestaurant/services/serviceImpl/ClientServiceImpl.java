package com.example.eRestaurant.services.serviceImpl;

import com.example.eRestaurant.entities.EClient;
import com.example.eRestaurant.repos.ClientRepository;
import com.example.eRestaurant.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientRepository clientRepository;
    @Override
    public List<EClient> getClients() {
        return clientRepository.findAll();
    }

    @Override
    public EClient getClient(Long id) {
        return clientRepository.findById(id).orElseGet(null);
    }

    @Override
    public EClient saveClient(EClient client) {
        return clientRepository.save(client);
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }
}
