package com.EjercicioSpring.Ejercicio9_CalculadoraCalorias.service;

import com.EjercicioSpring.Ejercicio9_CalculadoraCalorias.dto.IngredienteDTO;
import com.EjercicioSpring.Ejercicio9_CalculadoraCalorias.dto.PlatoDTO;
import com.EjercicioSpring.Ejercicio9_CalculadoraCalorias.entity.Ingrediente;
import com.EjercicioSpring.Ejercicio9_CalculadoraCalorias.repository.IngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ContadorCaloriasImpl implements IContadorCaloriasService {

    @Autowired
    IngredienteRepository ingredienteRepository;

    @Override
    public List<PlatoDTO> getCaloriasPlato(List<PlatoDTO> platos) {
        Random random = new Random();
        List<Ingrediente> ingredientes = ingredienteRepository.getAll();
        for (PlatoDTO plato : platos) {
            List<IngredienteDTO> ingredientesDTO = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                Ingrediente ingredienteAleatorio = ingredientes.get(random.nextInt(ingredientes.size()));
                ingredientesDTO.add(new IngredienteDTO(ingredienteAleatorio.getName(), ingredienteAleatorio.getCalories()));
            }
            plato.setIngredientes(ingredientesDTO);
            plato.actualizarTotal();
            plato.actualizarIngreMayorCalorias();
        }
        return platos;
    }
}
