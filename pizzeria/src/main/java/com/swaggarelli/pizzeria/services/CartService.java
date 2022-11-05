package com.swaggarelli.pizzeria.services;

import com.swaggarelli.pizzeria.models.*;
import com.swaggarelli.pizzeria.models.DTO.Cart;
import com.swaggarelli.pizzeria.models.DTO.ENUM.Base;
import com.swaggarelli.pizzeria.models.DTO.ENUM.Ingredients;
import com.swaggarelli.pizzeria.models.DTO.ENUM.Topping;
import com.swaggarelli.pizzeria.models.DTO.Pizza;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CartService {
    @Autowired
    private final IngredientService ingredientService;


    /**
     * @param cart The cart continas the pizzas this function will see if there is invintory to build each pizza
     * @return boolean true if possible, false if not
     */
    public Cart makePurchase(Cart cart){
        sortById compare = new sortById();
        List<Ingredient> ings = ingredientService.findAll();
        ArrayList<Ingredient> ing = new ArrayList<>(ings);
        Comparator<? super Ingredient> sortById = new sortById();
        ing.sort(sortById);
        log.info(String.valueOf(ing.get(0)));
        for(Pizza pie:cart.getPizzas()){
            Ingredients type  = null;
            type = Base.DOUGH; // if we get different types of doughs later change this to reflect
            Base cheese = Base.CHEESE; //if we get different cheeses later change to reflect
            switch (pie.getSize()){ // check how much Dough and Cheese is going to be needed
                case SMALL:
                    if(!ing.get(type.getID()-1).setStock(ing.get(type.getID()-1).getStock() - 1)) return new Cart();
                    if(!ing.get(cheese.getID()-1).setStock(ing.get(cheese.getID()).getStock()-1)) return new Cart();
                    break;
                case MEDIUM:
                    if(!ing.get(type.getID()-1).setStock(ing.get(type.getID()-1).getStock() - 2)) return new Cart();
                    if(!ing.get(cheese.getID()-1).setStock(ing.get(cheese.getID()-1).getStock()-2)) return new Cart();
                    break;
                case LARGE:
                    if(!ing.get(type.getID()-1).setStock(ing.get(type.getID()-1).getStock() - 3)) return new Cart();
                    if(!ing.get(cheese.getID()-1).setStock(ing.get(cheese.getID()-1).getStock()-3)) return new Cart();
                    break;
            }
            type = pie.getSauce();
            if(!ing.get(type.getID()-1).setStock(ing.get(type.getID()-1).getStock() - 1)) return new Cart();
            for(Topping top:pie.getToppings()){
                type = top; // get type of topping
                if(!ing.get(type.getID()-1).setStock(ing.get(type.getID()-1).getStock() - 1)) return new Cart();
                // reduce topping count by 1 if it goes below 0 return false immediately
            }
        }
        ingredientService.saveAll(ing);
        return cart;
    }
}

class sortById implements Comparator<Ingredient> {

    public int compare(Ingredient a, Ingredient b) {
        return a.getInventoryId() - b.getInventoryId();
    }
}
