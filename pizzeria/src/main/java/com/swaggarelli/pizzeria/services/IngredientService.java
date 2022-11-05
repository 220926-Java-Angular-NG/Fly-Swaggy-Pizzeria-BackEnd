package com.swaggarelli.pizzeria.services;

import com.swaggarelli.pizzeria.models.*;
import com.swaggarelli.pizzeria.models.DTO.ENUM.Base;
import com.swaggarelli.pizzeria.models.DTO.ENUM.Sauce;
import com.swaggarelli.pizzeria.models.DTO.ENUM.Topping;
import com.swaggarelli.pizzeria.repos.IngredientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientService {
    @Autowired
    private final IngredientRepo ingredientRepo;

    public IngredientService(IngredientRepo ingredientRepo) {
        this.ingredientRepo = ingredientRepo;
        for(Base ing:Base.values()){ // Generate the Inventory Rows
            if(FindByID(ing.getID()).getInventoryId() == -1) {
                Ingredient temp = new Ingredient();
                temp.setItem(ing.getName());
                temp.setStock(30);
                temp.setInventoryId(ing.getID());
                createUpdateIngredient(temp);
            }
        }
        for(Sauce ing:Sauce.values()){
            if(FindByID(ing.getID()).getInventoryId() == -1) {
                Ingredient temp = new Ingredient();
                temp.setItem(ing.getName());
                temp.setStock(20);
                temp.setInventoryId(ing.getID());
                createUpdateIngredient(temp);
            }
        }
        for(Topping ing: Topping.values()){
            if(FindByID(ing.getID()).getInventoryId() == -1) {
                Ingredient temp = new Ingredient();
                temp.setItem(ing.getName());
                temp.setStock(10);
                temp.setInventoryId(ing.getID());
                createUpdateIngredient(temp);
            }
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
    public Ingredient FindByID(Integer id){return ingredientRepo.findById(id).orElse(new Ingredient(-1));}
    public List<Ingredient> findAll(){
        return ingredientRepo.findAll();
    }
    public List<Ingredient> saveAll(List<Ingredient> ing){return ingredientRepo.saveAll(ing);}
}
