package com.meli.crudjpa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Joya {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int nro_identificatorio;
    String nombre;
    String material;
    Double peso;
    String particularidad;
    boolean posee_joya;
    boolean ventaONo;

}
