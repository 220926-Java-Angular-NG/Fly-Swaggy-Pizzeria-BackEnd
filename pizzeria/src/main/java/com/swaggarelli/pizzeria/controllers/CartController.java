package com.swaggarelli.pizzeria.controllers;


import com.swaggarelli.pizzeria.models.DTO.Cart;
import com.swaggarelli.pizzeria.services.CartService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    public Cart makePuchase(@RequestBody Cart cart){
        return cartService.makePurchase(cart);}
}
