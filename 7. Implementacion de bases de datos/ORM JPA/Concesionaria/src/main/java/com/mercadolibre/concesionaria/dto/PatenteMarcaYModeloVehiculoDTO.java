package com.mercadolibre.concesionaria.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter @NoArgsConstructor
public class PatenteMarcaYModeloVehiculoDTO extends PatenteYMarcaVehiculoDTO implements Serializable {
    private String modelo;
    public PatenteMarcaYModeloVehiculoDTO(String patente, String marca, String modelo){
        super(patente, marca);
        this.modelo = modelo;
    }
}
