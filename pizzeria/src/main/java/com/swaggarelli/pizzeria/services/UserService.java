package com.swaggarelli.pizzeria.services;

import com.swaggarelli.pizzeria.models.User;
import com.swaggarelli.pizzeria.repos.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;

    public User createUser(User user){
        return userRepo.save(user);
    }

    public User findUserById(Long userId){
        return userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
    }

    public User findUserByUsername(String username){
        return userRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found with username: " + username));
    }
}
