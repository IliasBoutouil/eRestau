package com.example.eRestaurant.controllers;

import com.example.eRestaurant.entities.Category;
import com.example.eRestaurant.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/categories")

public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @GetMapping
    ResponseEntity index()
    {
        return  ResponseEntity.ok(categoryService.getCategories());
    }
    @DeleteMapping("/{id}")
    ResponseEntity delete(@PathVariable Long id)
    {
        try {
            categoryService.deleteCategory(id);
            return  ResponseEntity.ok("Deleted");
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().body("Error deleting category "+e.getMessage());
        }
    }
//    @PutMapping("/{id}")
//    ResponseEntity update(@PathVariable Long id,@Valid @RequestBody Category category, BindingResult br)
//    {
//        if(!br.hasErrors()) return ResponseEntity.ok(categoryService.saveCategory(category));
//        return ResponseEntity.badRequest().body("Error updating category");
//    }
    @GetMapping("/{id}")
    ResponseEntity get(@PathVariable Long id)
    {
        return  ResponseEntity.ok(categoryService.getCategory(id));
    }
    @PostMapping
    ResponseEntity store(@Valid @RequestBody Category category, BindingResult br)
    {
        if(!br.hasErrors()) return ResponseEntity.ok(categoryService.saveCategory(category));
        return ResponseEntity.badRequest().body("Error creating category");
    }

}
