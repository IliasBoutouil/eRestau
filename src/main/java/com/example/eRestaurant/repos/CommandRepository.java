package com.example.eRestaurant.repos;

import com.example.eRestaurant.entities.ECommand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandRepository extends JpaRepository<ECommand,Long> {
}
