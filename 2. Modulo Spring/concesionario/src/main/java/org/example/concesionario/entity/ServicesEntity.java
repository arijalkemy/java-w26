package org.example.concesionario.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServicesEntity {
    private LocalDate date;
    private Long km;
    private String descripcion;
}
