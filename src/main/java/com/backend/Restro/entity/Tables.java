package com.backend.Restro.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Tables")
public class Tables {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer table_id;
    private Integer restro_id;
    private Integer seats;
}
