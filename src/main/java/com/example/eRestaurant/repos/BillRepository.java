package com.example.eRestaurant.repos;

import com.example.eRestaurant.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill,Long> {
}
