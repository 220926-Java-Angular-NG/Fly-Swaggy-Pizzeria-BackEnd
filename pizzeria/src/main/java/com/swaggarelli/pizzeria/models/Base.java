package com.swaggarelli.pizzeria.models;

public enum Base implements Ingredients<Base> {
    DOUGH("Dough"),
    CHEESE("Cheese");

    private final String name;

    Base(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
