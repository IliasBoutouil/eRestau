package com.example.eRestaurant.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dish implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private float price;
    private int cookTime;
    @ManyToMany(mappedBy = "dishes")
    //@JsonIgnore
    private Set<ECommand> commands=new HashSet<>();
    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;
    @ManyToMany
    @JoinTable(name = "dish_details",joinColumns = @JoinColumn(name = "dish_id"),inverseJoinColumns = @JoinColumn(name = "ingredient_id"))
    //@JsonIgnore
    private Set<Ingredient> ingredients= new HashSet<>();


}
