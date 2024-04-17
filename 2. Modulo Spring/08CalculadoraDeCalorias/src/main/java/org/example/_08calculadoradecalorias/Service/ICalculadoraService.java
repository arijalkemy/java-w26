package org.example._08calculadoradecalorias.Service;

import org.example._08calculadoradecalorias.DTO.CaloriasPlatoDTO;
import org.example._08calculadoradecalorias.DTO.IngredienteDTO;
import java.util.List;

public interface ICalculadoraService {
    CaloriasPlatoDTO calcularCaloriasDe(String nombrePlato, int peso);

    List<IngredienteDTO> obtenerIngredientesDe(String nombrePlato);

    IngredienteDTO obtenerIngredienteConMasCaloriasDe(String nombrePlato);
}
