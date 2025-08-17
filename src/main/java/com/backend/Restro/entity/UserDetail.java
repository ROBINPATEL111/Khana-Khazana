package com.backend.Restro.entity;


import jakarta.persistence.*;
//import org.springframework.data.annotation.Id;
import java.math.BigInteger;

@Entity
@Table(name = "UserDetail")
public class UserDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private BigInteger phone_number;
    private String password;

}
