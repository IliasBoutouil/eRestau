package com.example.eRestaurant.bootstrap;

import com.example.eRestaurant.entities.*;
import com.example.eRestaurant.repos.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Component
public class DbInitializer implements ApplicationListener<ContextRefreshedEvent> {
    ClientRepository clientRepository;
    BillRepository billRepository;
    CategoryRepository categoryRepository;
    CommandRepository commandRepository;
    DishRepository dishRepository;
    IngredientRepository ingredientRepository;

    public DbInitializer(ClientRepository clientRepository, BillRepository billRepository, CategoryRepository categoryRepository, CommandRepository commandRepository, DishRepository dishRepository, IngredientRepository ingredientRepository) {
        this.clientRepository = clientRepository;
        this.billRepository = billRepository;
        this.categoryRepository = categoryRepository;
        this.commandRepository = commandRepository;
        this.dishRepository = dishRepository;
        this.ingredientRepository = ingredientRepository;
    }
    @Transactional
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        //Saving clients
        EClient client1 = new EClient("Boutouil Ilias");
        EClient client2 = new EClient("Walim Salah");
        EClient client3 = new EClient("John Doe");
        clientRepository.saveAll(List.of(client1,client2,client3));
        //Saving categories
        Category category1= new Category("Sea Food");
        Category category2= new Category("Grill");
        Category category3= new Category("Salade");
        Category category4= new Category("Pasta");
        categoryRepository.saveAll(List.of(category1,category2,category3,category4));
        //Saving ingredients
        Ingredient ingredient1 = new Ingredient("Beef Steak");
        Ingredient ingredient2 = new Ingredient("Minced Meat");
        Ingredient ingredient3 = new Ingredient("Chicken Breast");
        Ingredient ingredient4 = new Ingredient("Turkey");
        Ingredient ingredient5 = new Ingredient("Shrimp");
        Ingredient ingredient6 = new Ingredient("Mashed Potato");
        Ingredient ingredient7 = new Ingredient("French fries");
        Ingredient ingredient8 = new Ingredient("Chicken Nuggets");
        Ingredient ingredient9 = new Ingredient("Pasta");
        Ingredient ingredient10 = new Ingredient("Spaghetti");
        ingredientRepository.saveAll(List.of(ingredient1,ingredient2,ingredient3,ingredient4,ingredient5,ingredient6,ingredient7,ingredient8,ingredient9,ingredient10));
        //Saving dishes
        Dish dish1 = new Dish(null,"American Steak",9.5f,10,null, category2,Set.of(ingredient1,ingredient9));
        Dish dish2 = new Dish(null,"Pasta",6f,15,null, category4,Set.of(ingredient2,ingredient9));
        Dish dish3 = new Dish(null,"Spaghetti Italiano",6.5f,15,null, category4,Set.of(ingredient10,ingredient2));
        Dish dish4 = new Dish(null,"Meat Potato",9.5f,10,null, category2,Set.of(ingredient2,ingredient6));
        Dish dish5 = new Dish(null,"Crispy Shrimps",2f,5,null, category1,Set.of(ingredient5));
        dishRepository.saveAll(List.of(dish1,dish2,dish3,dish4,dish5));
        //Saving commands
        ECommand command1 = new ECommand(null,"",client1,null,Set.of(dish1,dish5));
        ECommand command2 = new ECommand(null,"",client1,null,Set.of(dish2,dish5,dish4));
        ECommand command3 = new ECommand(null,"",client2,null,Set.of(dish5));
        ECommand command4 = new ECommand(null,"",client3,null,Set.of(dish3,dish4));
        commandRepository.saveAll(List.of(command1,command2,command3,command4));
        //Saving bills
        Bill bill1= new Bill(command1);
        Bill bill2= new Bill(command2);
        Bill bill3= new Bill(command3);
        Bill bill4= new Bill(command4);
        billRepository.saveAll(List.of(bill1,bill2,bill3,bill4));




    }
}
