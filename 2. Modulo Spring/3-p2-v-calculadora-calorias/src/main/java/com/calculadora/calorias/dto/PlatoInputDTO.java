package com.calculadora.calorias.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class PlatoInputDTO implements Serializable {

    private String nombrePlato;
    private List<IngredienteDTO> ingredienteList;

}
