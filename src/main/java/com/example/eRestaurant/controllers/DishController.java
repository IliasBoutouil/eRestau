package com.example.eRestaurant.controllers;

import com.example.eRestaurant.entities.Dish;
import com.example.eRestaurant.repos.DishCriteriaRepository;
import com.example.eRestaurant.services.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dishes")
public class DishController {
    @Autowired
    DishService dishService;
    @Autowired
    DishCriteriaRepository dishCriteriaRepository;
    @GetMapping
    ResponseEntity index()
    {
        return  ResponseEntity.ok(dishService.getDishes());
    }
    @GetMapping("/search")
    ResponseEntity search(@RequestParam(defaultValue = "") String name,@RequestParam(defaultValue = "") String category,@RequestParam(defaultValue = "0") double price)
    {
   return  ResponseEntity.ok(dishService.searchDishes(name,price,category));
    }
    @GetMapping("/{id}")
    ResponseEntity get(@PathVariable Long id)
    {
        return  ResponseEntity.ok(dishService.getDish(id));
    }
    @PostMapping
    ResponseEntity store(@RequestBody Dish dish)
    {
        try {
            return  ResponseEntity.ok(dishService.saveDish(dish));
        }
        catch (Exception e)
        {
            return  ResponseEntity.badRequest().body("Erreur au moment de la création "+e.getMessage());
        }
    }
    @DeleteMapping("/{id}")
    ResponseEntity delete(@PathVariable Long id)
    {
        dishService.deleteDish(id);
        return  ResponseEntity.ok().build();
    }

}
