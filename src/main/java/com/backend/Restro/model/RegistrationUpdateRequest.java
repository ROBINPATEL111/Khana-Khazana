package com.backend.Restro.model;

import lombok.Data;

@Data
public class RegistrationUpdateRequest {
    private String name;
    private  String email;
    private  String password;
}
