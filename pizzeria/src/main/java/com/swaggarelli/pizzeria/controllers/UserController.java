package com.swaggarelli.pizzeria.controllers;

import com.swaggarelli.pizzeria.models.User;
import com.swaggarelli.pizzeria.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }


    // GET localhost:8080/users/1 -> getByUserId
    @GetMapping("/{userId}")
    public User findUserById(@PathVariable Long userId){
        return userService.findUserById(userId);
    }

    @GetMapping("/{username}")
    public User findUserByUsername(@PathVariable String username) {
        return userService.findUserByUsername(username);
    }

}
