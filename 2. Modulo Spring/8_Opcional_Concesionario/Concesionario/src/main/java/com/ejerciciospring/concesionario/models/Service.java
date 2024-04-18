package com.ejerciciospring.concesionario.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Service {
    private LocalDate date;
    private Integer kilometers;
    public String descriptions;
}
