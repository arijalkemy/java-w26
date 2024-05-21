package com.mercadolibre.concesionaria.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter @NoArgsConstructor
public class PatenteYMarcaVehiculoDTO extends PatenteVehiculoDTO implements Serializable {
    private String marca;

    public PatenteYMarcaVehiculoDTO(String patente, String marca) {
        super(patente);
        this.marca = marca;
    }
}
