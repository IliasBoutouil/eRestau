package com.example.eRestaurant.controllers;

import com.example.eRestaurant.services.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/commands")

public class CommandController {
    @Autowired
    CommandService commandService;
    @GetMapping
    ResponseEntity index()
    {
        return  ResponseEntity.ok(commandService.getCommands());
    }
}
