package com.swaggarelli.pizzeria.models;

public enum Topping implements Ingredients<Topping> {
    PEPPERONI("Pepperoni"),
    SAUSAGE("Sasuage"),
    MUSHROOMS("Mushrooms"),
    BACON("Bacon"),
    CHICKEN("Chicken"),
    ONIONS("Onions"),
    BELL_PEPPERS("Bell_Pepper"),
    PINEAPPLE("Pineapple"),
    JALAPENOS("Jalapenos"),
    HAM("Ham"),
    FS_SEASONING("FS_Seasoning");

    private final String name;

    Topping(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
