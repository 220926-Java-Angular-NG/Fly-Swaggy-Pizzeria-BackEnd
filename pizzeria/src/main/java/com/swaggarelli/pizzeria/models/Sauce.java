package com.swaggarelli.pizzeria.models;

public enum Sauce implements Ingredients<Sauce> {
    TOMATO("Tomato"),
    BBQ("BBQ"),
    ALFREDO("Alfredo"),
    BUFFALO("Buffalo");

    private final String name;

    Sauce(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
