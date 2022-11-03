package com.swaggarelli.pizzeria.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(unique = true, length = 20)
    @NotNull
    private String username;

    @Column(length = 15)
    @NotNull
    private String password;

    @Column(length = 24)
    private String firstName;

    @Column(length = 24)
    private String lastName;

    @Column(length = 64)
    private String email;

    @Column(length = 10)
    private String phoneNumber;

    @Column(length = 30)
    private String address;

    @Column(length = 30)
    private String address2;

    @Column(length = 5)
    private String zipCode;

}
