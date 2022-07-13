package com.example.eRestaurant.services.serviceImpl;

import com.example.eRestaurant.entities.ECommand;
import com.example.eRestaurant.repos.CommandRepository;
import com.example.eRestaurant.services.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class CommandServiceImpl implements CommandService {
    @Autowired
   CommandRepository commandRepository;
    @Override
    public List<ECommand> getCommands() {
        return commandRepository.findAll();
    }

    @Override
    public ECommand getCommand(Long id) {
        return commandRepository.findById(id).orElseGet(null);
    }

    @Override
    public ECommand saveCommand(ECommand command) {
        return commandRepository.save(command);
    }

    @Override
    public void deleteCommand(Long id) {
        commandRepository.deleteById(id);
    }
}
