package com.swaggarelli.pizzeria.models.DTO.RequestResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequest {
    String Username;
    String Password;
}
