package org.example.miniseries.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "miniserie")
public class Miniserie {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 30)
    private String name;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "amount_of_awards")
    private Integer amount_of_awards;
}
