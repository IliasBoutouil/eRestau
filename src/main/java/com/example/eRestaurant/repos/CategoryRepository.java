package com.example.eRestaurant.repos;

import com.example.eRestaurant.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
