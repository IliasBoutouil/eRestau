package com.example.eRestaurant.services.serviceImpl;

import com.example.eRestaurant.entities.Ingredient;
import com.example.eRestaurant.repos.IngredientRepository;
import com.example.eRestaurant.services.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class IngredientServiceImpl implements IngredientService {

    @Autowired
    IngredientRepository ingredientRepository;
    @Override
    public List<Ingredient> getIngredients() {
        return ingredientRepository.findAll();
    }

    @Override
    public Ingredient getIngredient(Long id) {
        return ingredientRepository.findById(id).orElse(null);
    }

    @Override
    public Ingredient saveIngredient(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    @Override
    public void deleteIngredient(Long id) {
        ingredientRepository.deleteById(id);
    }
}
