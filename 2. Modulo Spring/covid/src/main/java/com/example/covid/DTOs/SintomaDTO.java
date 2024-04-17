package com.example.covid.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@AllArgsConstructor
@Data
public class SintomaDTO {
    private String nombre;
    private int nivelDeGravedad;
}
