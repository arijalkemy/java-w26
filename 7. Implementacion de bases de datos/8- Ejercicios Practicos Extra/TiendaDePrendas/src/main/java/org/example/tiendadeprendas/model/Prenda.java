package org.example.tiendadeprendas.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "prenda")
public class Prenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long codigo;
    String nombre;
    String marca;
    String color;
    String talla;
    Integer cantidad;
    Double precio;
}
