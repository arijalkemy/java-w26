package com.bootcamp.covid19.dto.Sintoma;

import lombok.Data;

import java.io.Serializable;
@Data
public class SintomaDto implements Serializable {

    private String codigo;
    private String nombre;
    private String nivelDeGravedad;
}
