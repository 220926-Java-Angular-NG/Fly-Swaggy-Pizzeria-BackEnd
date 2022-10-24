package org.swagarelli.models;

import java.util.ArrayList;

// Pizza class is a model class for the Pizzeria project.
//
public class Pizza {

    // Properties
    private String crust;
    private String sauce;
    private String cheese;
    private ArrayList<String> toppings;

    // Constructors
    // No-arg Constructor
    public Pizza() {
        crust = "Normal";
        sauce = "Tomato";
        cheese = "Regular";
        toppings = new ArrayList<String>();
    }

    // Overloading the constructor with arguments

    public Pizza(String crust, String sauce, String cheese, ArrayList<String> toppings) {
        this.crust = crust;
        this.sauce = sauce;
        this.cheese = cheese;
        this.toppings = toppings;
    }

    // Getters and setters

    public String getCrust() {
        return crust;
    }

    public void setCrust(String crust) {
        this.crust = crust;
    }

    public String getSauce() {
        return sauce;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public String getCheese() {
        return cheese;
    }

    public void setCheese(String cheese) {
        this.cheese = cheese;
    }

    public ArrayList<String> getToppings() {
        return toppings;
    }

    public void setToppings(ArrayList<String> toppings) {
        this.toppings = toppings;
    }
}
