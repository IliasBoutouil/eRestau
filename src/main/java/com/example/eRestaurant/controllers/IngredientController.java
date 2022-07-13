package com.example.eRestaurant.controllers;

import com.example.eRestaurant.services.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ingredients")
public class IngredientController {
    @Autowired
    IngredientService ingredientService;
    @GetMapping
    ResponseEntity index()
    {
        return  ResponseEntity.ok(ingredientService.getIngredients());
    }
}
