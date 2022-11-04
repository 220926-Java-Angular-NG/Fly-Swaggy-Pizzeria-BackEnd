package com.swaggarelli.pizzeria.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity(name = "inventory")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Ingredient {

    @Id
    private Integer inventoryId;

    @Column(unique = true, length = 20)
    @NotNull
    private String item;

    @Min(0)
    @NotNull
    private int stock;

    public boolean setStock(int stock) { // simply throw a false if the stock ever goes below zero
        this.stock = stock;
        return this.stock >= 0;
    }
}
