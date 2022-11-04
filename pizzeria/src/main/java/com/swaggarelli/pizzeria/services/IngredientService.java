package com.swaggarelli.pizzeria.services;

import com.swaggarelli.pizzeria.models.*;
import com.swaggarelli.pizzeria.repos.IngredientRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {
    private final IngredientRepo ingredientRepo;

    public IngredientService(IngredientRepo ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
        for(Base ing:Base.values()){ // Generate the Inventory Rows
            Ingredient temp = new Ingredient();
            temp.setItem(ing.getName());
            temp.setStock(1);
            temp.setInventoryId(ing.getID());
            createUpdateIngredient(temp);
        }
        for(Sauce ing:Sauce.values()){
            Ingredient temp = new Ingredient();
            temp.setItem(ing.getName());
            temp.setStock(1);
            temp.setInventoryId(ing.getID());
            createUpdateIngredient(temp);
        }
        for(Topping ing: Topping.values()){
            Ingredient temp = new Ingredient();
            temp.setItem(ing.getName());
            temp.setStock(1);
            temp.setInventoryId(ing.getID());
            createUpdateIngredient(temp);
        }
    }

    /**
     * @param ingredient the element to be added to the database, or updated if it has ID initlaized
     * @return return the created element
     */
    public Ingredient createUpdateIngredient(Ingredient ingredient){
        return ingredientRepo.save(ingredient);
    }

    /**
     * @param name String name of an ingredient
     * @return The found ingredeitn (ID, name, amount)
     */
    public Ingredient getByName(String name){
        return ingredientRepo.findByItem(name)
                .orElseThrow(() -> new RuntimeException("Ingredient not found with name: " + name));
    }
    public List<Ingredient> findAll(){
        return ingredientRepo.findAll();
    }
    public List<Ingredient> saveAll(List<Ingredient> ing){return ingredientRepo.saveAll(ing);}
}
