package com.meli.PracticaHQL.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatenteDto {
    private Long id;
    private String patente;
    private String marca;

    public PatenteDto(Long id, String patente) {
        this.id = id;
        this.patente = patente;
    }
}
