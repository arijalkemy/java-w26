package com.example.showroom_vivo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "clothes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clothes {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long code;
    private String name;
    private String type;
    private String brand;
    private String color;
    private Double size;
    private Integer amount;
    private Double price;
}
