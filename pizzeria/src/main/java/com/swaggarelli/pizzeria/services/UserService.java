package com.swaggarelli.pizzeria.services;

import com.swaggarelli.pizzeria.models.User;
import com.swaggarelli.pizzeria.repos.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private final UserRepo userRepo;

    /**
     * @param user Entity of type User gotten from an API call (if ID has an assigned value within the table update instead)
     *             This Function first retrieves the old data from the table, then updates the table
     * @return the new entity (either created or updated)
     */
    public User createUpdateUser(User user){
        return userRepo.save(user);
    }

    public User findUserById(Long userId){
        return userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
    }

    public List<User> findAllUsers(){
        return userRepo.findAll();
    }

    public User findUserByUsername(String username){
        return userRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found with username: " + username));
    }

    public User login(String username, String password) {
        return userRepo.findByUsernameAndPassword(username, password)
                .orElseThrow( () -> new RuntimeException("Please verify your username or password"));
    }
}