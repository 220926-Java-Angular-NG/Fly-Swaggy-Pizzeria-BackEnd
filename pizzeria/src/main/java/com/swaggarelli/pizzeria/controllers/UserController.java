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

    @PostMapping("/register")
    public User createUser(@RequestBody User user){
        return userService.createUpdateUser(user);
    }

    @PutMapping ("/myProfile")
    public User updateUser(@RequestBody User user){return userService.createUpdateUser(user);}

    // GET localhost:8080/users/1 -> getByUserId
    @GetMapping("/{userId}")
    public User findUserById(@PathVariable Long userId){
        return userService.findUserById(userId);
    }


    @GetMapping("/users")
    public List<User> findAllUsers(){
        return userService.findAllUsers();
    }


    @PostMapping ("/login")
    public User loginUser(@RequestBody String credentials){
        int space = credentials.indexOf(" ");
        String username = credentials.substring(0, space);
        String password = credentials.substring(space + 1);

        return userService.login(username, password);
    }


    //both of this and the one above are the same end point /users/'variable'
//    @GetMapping("/{username}")
//    public User findUserByUsername(@PathVariable String username) {
//        return userService.findUserByUsername(username);
//    }

}