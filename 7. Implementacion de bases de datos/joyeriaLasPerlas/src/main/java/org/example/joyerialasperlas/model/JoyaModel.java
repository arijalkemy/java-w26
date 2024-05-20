package org.example.joyerialasperlas.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "joyas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JoyaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "material")
    private String material;

    @Column(name = "peso")
    private float peso;

    @Column(name = "descripcion")
    private String particularidad;

    @Column(name = "posee_piedra")
    private boolean poseePiedra;

    @Column(name = "ventaONo")
    private boolean ventaONo;
}
