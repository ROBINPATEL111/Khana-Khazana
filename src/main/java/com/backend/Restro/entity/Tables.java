package com.backend.Restro.entity;
import jakarta.persistence.*;
import lombok.Cleanup;
import lombok.Data;

@Data
@Entity
@Table(name = "Tables")
public class Tables {
    @Id
    @SequenceGenerator(name = "table_id_seq", sequenceName = "table_id_seq",allocationSize = 1 , initialValue = 5)
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "table_id_seq")

    @Column(name = "table_id")
    private Integer table_id;

    @ManyToOne
    @JoinColumn(name ="restro_id" , referencedColumnName = "restro_id")
    private Restaurant restaurant;

    @Column(name = "seats")
    private Integer seats;
}
