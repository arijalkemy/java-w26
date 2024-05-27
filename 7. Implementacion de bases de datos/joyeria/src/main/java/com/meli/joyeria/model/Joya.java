package com.meli.joyeria.model;

import com.meli.joyeria.enums.Material;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
public class Joya {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="nro_identificatorio")
    private Long id;
    private String nombre;
    @Enumerated(EnumType.STRING)
    private Material material;
    private Float peso;
    private String particularidad;
    @Column(name="posee_piedra")
    private boolean poseePiedra;
    @Column(name="tiene_piedra")
    private boolean ventaOno;
}
