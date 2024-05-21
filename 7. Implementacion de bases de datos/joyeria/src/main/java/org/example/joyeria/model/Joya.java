package org.example.joyeria.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "joyas")
@Data
public class Joya {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "nro_identificatorio")
    private Long id;
    private String nombre;
    private String material;
    private Double peso;
    private String particularidad;
    @Column(name = "posee_piedra")
    private Boolean poseePiedra;
    private boolean ventaONo;
}
