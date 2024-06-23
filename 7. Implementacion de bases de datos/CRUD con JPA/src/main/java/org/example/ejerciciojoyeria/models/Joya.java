package org.example.ejerciciojoyeria.models;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Joyas")
public class Joya {
    @Id
    @Column(name = "nro_identificatorio")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    private String material;
    private Double peso;
    private String particularidades;
    @Column(name = "posee_piedra")
    private boolean poseePiedra;
    @Column(name = "ventaONo")
    private boolean venta=true;
}
