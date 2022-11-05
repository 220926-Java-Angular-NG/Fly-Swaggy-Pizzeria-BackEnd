package com.swaggarelli.pizzeria.models.DTO.RequestResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EditRequest {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private String address2;
    private String zipCode;
}
