package org.example.lasperlas.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Joya {
    @Id
    @GeneratedValue
    Long Id;
    String nombre;
    String material;
    Double peso;
    String particularidad;
    Boolean posee_piedra;
    Boolean ventaONo;
}
