package org.example.ejercicios_extra_bd_relacional.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "prenda")
public class Prenda {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @Column(name = "marca", nullable = false)
    private String marca;

    @Column(name = "color", nullable = false)
    private String color;

    @Column(name = "talle", nullable = false)
    private String talle;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "precio_venta", nullable = false)
    @Digits(integer = 6, fraction = 2)
    private BigDecimal precioVenta;
}
