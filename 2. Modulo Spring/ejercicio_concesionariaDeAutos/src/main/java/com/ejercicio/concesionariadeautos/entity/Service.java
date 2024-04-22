package com.ejercicio.concesionariadeautos.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
public class Service {
    private LocalDate date;
    private int kilometers;
    private String descriptions;
}
