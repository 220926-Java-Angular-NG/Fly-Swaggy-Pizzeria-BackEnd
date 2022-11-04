package com.swaggarelli.pizzeria.models;
/**
 * Enum Handeling our types of toppings
 */
public enum Topping implements Ingredients<Topping> {
    PEPPERONI("Pepperoni",7),
    SAUSAGE("Sasuage",8),
    MUSHROOMS("Mushrooms",9),
    BACON("Bacon",10),
    CHICKEN("Chicken",11),
    ONIONS("Onions",12),
    BELL_PEPPERS("Bell_Pepper",13),
    PINEAPPLE("Pineapple",14),
    JALAPENOS("Jalapenos",15),
    HAM("Ham",16),
    FS_SEASONING("FS_Seasoning",17);

    private final String name;

    private final int ID;
    Topping(String name, int ID) {
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
