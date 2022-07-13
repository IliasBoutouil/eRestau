package com.example.eRestaurant.entities.DTO;

import com.example.eRestaurant.entities.Dish;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DishDTO {
    private Long id;
    private String name;
    private float price;
    private int cookTime;

    public static DishDTO toDTO(Dish dish)
    {
        DishDTO DTO = new DishDTO();
        DTO.id=dish.getId();
        DTO.name= dish.getName();
        DTO.price=dish.getPrice();
        DTO.cookTime=dish.getCookTime();
        return DTO;
    }
    public static Dish toEntity(DishDTO dishDTO)
    {
        Dish dish = new Dish();
        dish.setId(dishDTO.getId());
        dish.setName(dishDTO.getName());
        dish.setPrice(dishDTO.getPrice());
        dish.setCookTime(dishDTO.getCookTime());
        return dish;
    }
}
