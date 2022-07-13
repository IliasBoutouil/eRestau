package com.example.eRestaurant.repos;

import com.example.eRestaurant.entities.EClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<EClient,Long> {
}
