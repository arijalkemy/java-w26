package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SiniestroDTO {
    private int idSiniestro;
    private Date fechaSiniestro;
    private double perdidaEconomica;
    private int idVehiculoDenunciado;

    // Constructores, getters y setters
}
