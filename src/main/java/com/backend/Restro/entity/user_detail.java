package com.backend.Restro.entity;


import jakarta.persistence.*;
//import org.springframework.data.annotation.Id;
import java.math.BigInteger;
import java.math.BigInteger;
import java.util.Formatter;

@Entity
@Table(name = "user_detail")
public class user_detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private BigInteger phone_number;
    private String password;

}
