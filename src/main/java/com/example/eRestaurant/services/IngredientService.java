package com.example.eRestaurant.services;

import com.example.eRestaurant.entities.Ingredient;

import java.util.List;

public interface IngredientService {
    List<Ingredient> getIngredients();
    Ingredient getIngredient(Long id);
    Ingredient saveIngredient(Ingredient ingredient);
    void deleteIngredient(Long id);
}
