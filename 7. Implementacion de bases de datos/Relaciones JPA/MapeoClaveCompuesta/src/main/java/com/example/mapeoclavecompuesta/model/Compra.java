package com.example.mapeoclavecompuesta.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name ="compras")
@IdClass(value = CompraKey.class)
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long clienteId;
    @Id
    private LocalDate fecha = LocalDate.now();

    private String empresa;
}
