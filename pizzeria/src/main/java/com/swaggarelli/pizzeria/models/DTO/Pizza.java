package com.swaggarelli.pizzeria.models.DTO;

import com.swaggarelli.pizzeria.models.DTO.ENUM.Sauce;
import com.swaggarelli.pizzeria.models.DTO.ENUM.Topping;
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



    public enum Size{
        SMALL, MEDIUM, LARGE
    }

    private enum Crust{
        REGULAR, THIN, NO_CRUST
    }
}
