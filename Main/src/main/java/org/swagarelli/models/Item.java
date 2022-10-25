package org.swagarelli.models;

public class Item {
    double price;


    public Item() {
        this.price = 0;
    }

    public Item(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
