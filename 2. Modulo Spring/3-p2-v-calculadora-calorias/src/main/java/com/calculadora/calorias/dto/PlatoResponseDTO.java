package com.calculadora.calorias.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class PlatoResponseDTO extends PlatoInputDTO {

    private Integer calorias;

    private IngredienteDTO caloric;

    public PlatoResponseDTO(PlatoInputDTO platoInputDTO) {
        this.setIngredienteList(platoInputDTO.getIngredienteList());
        this.setNombrePlato(platoInputDTO.getNombrePlato());
    }
}
