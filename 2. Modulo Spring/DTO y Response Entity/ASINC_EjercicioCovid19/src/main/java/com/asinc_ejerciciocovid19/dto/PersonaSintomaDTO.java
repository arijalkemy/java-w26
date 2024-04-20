package com.asinc_ejerciciocovid19.dto;

import com.asinc_ejerciciocovid19.entidad.Sintoma;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PersonaSintomaDTO {
    private String nombre;
    private String apellido;
    private List<SintomaDTO> sintomas;
}
