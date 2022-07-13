package com.example.eRestaurant.services;

import com.example.eRestaurant.entities.EClient;

import java.util.List;

public interface ClientService {

    List<EClient> getClients();
    EClient getClient(Long id);
    EClient saveClient(EClient client);
    void deleteClient(Long id);
}
