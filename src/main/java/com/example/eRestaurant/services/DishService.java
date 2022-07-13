package com.example.eRestaurant.services;

import com.example.eRestaurant.entities.DTO.DishDTO;
import com.example.eRestaurant.entities.Dish;

import java.util.List;

public interface DishService {
    List<DishDTO> getDishes();
    DishDTO getDish(Long id);
    DishDTO saveDish(Dish dish);
    void deleteDish(Long id);
    List<DishDTO> searchDishes(String name, double price, String category);
}
