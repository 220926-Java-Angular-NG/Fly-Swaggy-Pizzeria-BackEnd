package com.swaggarelli.pizzeria.controllers;


import com.swaggarelli.pizzeria.models.Cart;
import com.swaggarelli.pizzeria.models.User;
import com.swaggarelli.pizzeria.services.CartService;
import com.swaggarelli.pizzeria.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;


    @PostMapping("/purchase")
    public Cart makePuchase(@RequestBody Cart cart){return cartService.makePurchase(cart);}
}
