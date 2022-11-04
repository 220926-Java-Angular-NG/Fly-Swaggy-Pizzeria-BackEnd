package com.swaggarelli.pizzeria.controllers;

import com.swaggarelli.pizzeria.models.DTO.AuthenticationRequest;
import com.swaggarelli.pizzeria.models.DTO.RegistrationRequest;
import com.swaggarelli.pizzeria.models.DTO.TokenResponse;
import com.swaggarelli.pizzeria.services.JWTService;
import com.swaggarelli.pizzeria.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public TokenResponse register(@RequestBody RegistrationRequest registrationRequest){
        return userService.createUser(registrationRequest);
    }
    @PostMapping("/login")
    public TokenResponse login(@RequestBody AuthenticationRequest authenticationRequest){
        return userService.loginUser(authenticationRequest);
    }
}
