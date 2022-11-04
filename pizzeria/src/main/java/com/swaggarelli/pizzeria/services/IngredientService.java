package com.swaggarelli.pizzeria.services;

import com.swaggarelli.pizzeria.models.*;
import com.swaggarelli.pizzeria.repos.IngredientRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
public class IngredientService {
    private final IngredientRepo ingredientRepo;

    public IngredientService(IngredientRepo ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
        for(Base ing:Base.values()){
            Ingredient temp = new Ingredient();
            temp.setItem(ing.getName());
            temp.setStock(1);
            createIngredient(temp);
        }
        for(Sauce ing:Sauce.values()){
            Ingredient temp = new Ingredient();
            temp.setItem(ing.getName());
            temp.setStock(1);
            createIngredient(temp);
        }
        for(Topping ing: Topping.values()){
            Ingredient temp = new Ingredient();
            temp.setItem(ing.getName());
            temp.setStock(1);
            createIngredient(temp);
        }
    }

    /**
     * @param ingredient the element to be added to the database
     * @return return the created element
     */
    public Ingredient createIngredient(Ingredient ingredient){
        return ingredientRepo.save(ingredient);
    }
}
