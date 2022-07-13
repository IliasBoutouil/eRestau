package com.example.eRestaurant.services;

import com.example.eRestaurant.entities.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getCategories();
    Category getCategory(Long id);
    Category saveCategory(Category category);
    void deleteCategory(Long id);
}
