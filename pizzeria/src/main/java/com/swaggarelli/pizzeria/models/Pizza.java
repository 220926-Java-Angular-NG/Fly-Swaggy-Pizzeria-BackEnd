package com.swaggarelli.pizzeria.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Pizza {

    private Size size;

    private Crust crust;

    private Sauce sauce;

    private List<Topping> toppings;



    private enum Size{
        SMALL, MEDIUM, LARGE
    }

    private enum Crust{
        REGULAR, THIN, NO_CRUST
    }
}
