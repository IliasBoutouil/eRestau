package com.example.eRestaurant.services;

import com.example.eRestaurant.entities.ECommand;

import java.util.List;

public interface CommandService {
    List<ECommand> getCommands();
    ECommand getCommand(Long id);
    ECommand saveCommand(ECommand command);
    void deleteCommand(Long id);
}
