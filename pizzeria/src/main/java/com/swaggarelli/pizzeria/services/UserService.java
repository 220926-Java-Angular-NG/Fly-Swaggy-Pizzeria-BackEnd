package com.swaggarelli.pizzeria.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.swaggarelli.pizzeria.models.DTO.AuthenticationRequest;
import com.swaggarelli.pizzeria.models.DTO.RegistrationRequest;
import com.swaggarelli.pizzeria.models.DTO.TokenResponse;
import com.swaggarelli.pizzeria.models.User;
import com.swaggarelli.pizzeria.repos.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepo userRepo;
    private final ObjectMapper objectMapper;
    private final JWTService jwtService;
    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;
    /**
     * @param user Entity of type User gotten from an API call (if ID has an assigned value within the table update instead)
     *             This Function first retrieves the old data from the table, then updates the table
     * @return the new entity (either created or updated)
     */
    public User createUpdateUser(User user){
        return userRepo.save(user);
    }

    public TokenResponse createUser(RegistrationRequest registrationRequest){
       User temp = objectMapper.convertValue(registrationRequest, User.class);
       temp.setPassword(passwordEncoder.encode(temp.getPassword()));
       userRepo.save(temp);
       String token = jwtService.generateToken(temp);
       return new TokenResponse(token);
    }

    public User findUserById(Long userId){
        return userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
    }

    public User findUserByUsername(String username){
        return userRepo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found with username: " + username));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return findUserByUsername(username);
    }



    public TokenResponse loginUser(AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getUsername(),
                        authenticationRequest.getPassword())
        );
        User temp = findUserByUsername(authenticationRequest.getUsername());
        String token = jwtService.generateToken(temp);
        return new TokenResponse(token);

    }
}
