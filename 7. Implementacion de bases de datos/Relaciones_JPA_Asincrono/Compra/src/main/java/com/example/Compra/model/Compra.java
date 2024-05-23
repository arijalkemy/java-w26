package com.example.Compra.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@IdClass(value=CompraKey.class)
public class Compra {
    @Id
    private Long clienteId;
    @Id
    private LocalDate fecha;
    private Long productoId;
    private String codigoRebaja;

}
