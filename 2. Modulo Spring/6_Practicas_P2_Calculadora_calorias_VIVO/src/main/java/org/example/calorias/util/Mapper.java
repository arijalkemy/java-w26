package org.example.calorias.util;

import org.example.calorias.dto.PlatoDTO;
import org.example.calorias.dto.PlatoJsonDTO;
import org.example.calorias.entity.Ingrediente;
import org.example.calorias.entity.Plato;
import org.modelmapper.ModelMapper;

import java.util.List;

public class Mapper {

    public static PlatoDTO toPlatoDTO(Plato plato) {
        return new ModelMapper().map(plato, PlatoDTO.class);
    }

    public static Plato toPlato(PlatoJsonDTO plato) {
        // ModelMapper no funciona porque los atributos están escritos en distintos idiomas

        List<Ingrediente> ingredientes = plato.getIngredients().stream()
            .map(ingredienteJsonDTO -> new Ingrediente(
                ingredienteJsonDTO.getName(), ingredienteJsonDTO.getCalories()
            ))
            .toList();

        return new Plato(plato.getName(), ingredientes);
    }
}
