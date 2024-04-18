package com.calculadora.calorias.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class IngredienteDTO implements Serializable {

    private String nombre;

    private Integer calorias;

    private Integer peso;

}
