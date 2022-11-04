package com.swaggarelli.pizzeria.models;

/**
 * This Enum is the Base of the Pizza Cheese and Dough IDs for the database
 */
public enum Base implements Ingredients<Base> {
    DOUGH("Dough",1),
    CHEESE("Cheese",2);

    private final String name;
    private final int ID;
    Base(String name, int ID) {
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
