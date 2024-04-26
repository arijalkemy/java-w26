package com.calculadora.calorias.Dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ListaDeIngredientesDto {

    List<IngredienteDto> ingredientes = new ArrayList<>();
}
