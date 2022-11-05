package com.swaggarelli.pizzeria.models.DTO.ENUM;

/**
 *
 * @param <T> and Interface for Enums within our Inventory table
 */
public interface Ingredients<T extends Enum<T>> {
    String getName();
    int getID();
}

