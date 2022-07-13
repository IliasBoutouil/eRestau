package com.example.eRestaurant.controllers;

import com.example.eRestaurant.entities.EClient;
import com.example.eRestaurant.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController @RequestMapping("/api/clients")
public class ClientController {
    @Autowired
    ClientService clientService;
    @GetMapping
    ResponseEntity index()
    {
        return  ResponseEntity.ok(clientService.getClients());
    }
    @GetMapping("/{id}")
    ResponseEntity display(@PathVariable Long id)
    {
        EClient client = clientService.getClient(id);
        if(client!=null)
        return  ResponseEntity.ok(client);
        return ResponseEntity.badRequest().build();
    }

}
