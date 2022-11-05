package com.swaggarelli.pizzeria.services;

import com.swaggarelli.pizzeria.models.DTO.RequestResponse.EditRequest;
import com.swaggarelli.pizzeria.models.User;
import com.swaggarelli.pizzeria.repos.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

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

    public User findUserByUsername(String username){
        return userRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found with username: " + username));
    }

}