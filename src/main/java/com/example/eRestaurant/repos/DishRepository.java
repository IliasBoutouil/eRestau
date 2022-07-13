package com.example.eRestaurant.repos;

import com.example.eRestaurant.entities.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DishRepository extends JpaRepository<Dish,Long>, JpaSpecificationExecutor<Dish> {
}
