package com.example.calculadoracalorias.DTO;

import com.example.calculadoracalorias.entity.Ingrediente;
import com.example.calculadoracalorias.entity.Plato;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@AllArgsConstructor
@Data
public class PlatoRensposeDTO {
    private Integer totalCalorias;
    private Plato plato;
    private Ingrediente maxCalorias;
}
