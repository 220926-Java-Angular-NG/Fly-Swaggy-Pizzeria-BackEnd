package com.swaggarelli.pizzeria.models.DTO.ENUM;

/**
 * Enum Handeling our types of sauces
 */
public enum Sauce implements Ingredients<Sauce> {
    TOMATO("Tomato",3),
    BBQ("BBQ",4),
    ALFREDO("Alfredo",5),
    BUFFALO("Buffalo",6);

    private final String name;

    private final int ID;
    Sauce(String name, int ID) {
        this.name = name;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    @Override
    public int getID() {
        return ID;
    }
}
