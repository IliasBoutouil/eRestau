package com.example.eRestaurant.services.serviceImpl;

import com.example.eRestaurant.entities.DTO.DishDTO;
import com.example.eRestaurant.entities.Dish;
import com.example.eRestaurant.repos.DishRepository;
import com.example.eRestaurant.services.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class DishServiceImpl implements DishService {

    @Autowired
    DishRepository dishRepository;
    @Override
    public List<DishDTO> getDishes()
    {
        return dishRepository.findAll().stream().map(DishDTO::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<DishDTO> searchDishes(String name, double price, String category) {
        List<Dish> dishes= dishRepository.findAll((Specification<Dish>)(root,cq,cb)->{
            Predicate p = cb.conjunction();
            if(name!=null) {
                p = cb.and(p, cb.like(root.get("name"), "%" + name + "%"));
            }
            if(price>0)
                p=cb.and(p,cb.ge(root.get("price"),price));
            if(category!=null)
                p = cb.and(p,cb.like(root.get("category").get("name"),"%"+category+"%"));
            cq.orderBy(cb.asc(root.get("price")),cb.desc(root.get("name")));
            return  p;
        });
        return dishes.stream().map(DishDTO::toDTO).collect(Collectors.toList());
    }

    @Override
    public DishDTO getDish(Long id) {
        Dish dish = dishRepository.findById(id).orElseGet(null);
        return DishDTO.toDTO(dish);

    }

    @Override
    public DishDTO saveDish(Dish dish) {
        Dish saved = dishRepository.save(dish);
        return DishDTO.toDTO(saved) ;
    }

    @Override
    public void deleteDish(Long id) {
        dishRepository.deleteById(id);
    }
}
