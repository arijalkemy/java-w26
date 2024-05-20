package com.backendbootcamp.firstcrud.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "joyas")
@Data

public class Jewel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "nombre")
    private String name;
    @Column(name = "particularidad")
    private String notes;
    @Column(name = "posee_piedra")
    private Boolean hasGem;
    @Column(name = "ventaONo")
    private Boolean inSale;
    @Column(name = "material")
    private String material;
    @Column(name = "peso")
    private int weight;

}
