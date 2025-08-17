package com.backend.Restro.entity;
import jakarta.persistence.*;
import lombok.Data;
import java.math.BigInteger;

@Data
@Entity
@Table(name = "UserDetail")
public class UserDetail {
    @Id
    @SequenceGenerator(name = "user_id_seq" , sequenceName = "user_id_seq", allocationSize =1,initialValue = 5)
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "user_id_seq")

    @Column(name = "user_id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private BigInteger phone_number;

    @Column(name = "password")
    private String password;
}
