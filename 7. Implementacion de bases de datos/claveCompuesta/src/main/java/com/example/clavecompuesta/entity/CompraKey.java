package com.example.clavecompuesta.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompraKey implements Serializable {
    private Long clienteID;
    private LocalDate fecha;
}
