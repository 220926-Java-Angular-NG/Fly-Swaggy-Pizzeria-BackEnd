package com.swaggarelli.pizzeria.repos;

import com.swaggarelli.pizzeria.models.Ingredient;
import com.swaggarelli.pizzeria.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IngredientRepo extends JpaRepository<Ingredient, Integer> {

    Optional<Ingredient> findByItem(String item);
}
