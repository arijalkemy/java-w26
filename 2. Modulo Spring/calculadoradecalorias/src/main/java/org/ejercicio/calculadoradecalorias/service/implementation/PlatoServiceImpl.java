package org.ejercicio.calculadoradecalorias.service.implementation;

import org.ejercicio.calculadoradecalorias.dto.IngredienteDTO;
import org.ejercicio.calculadoradecalorias.dto.PlatoDTO;
import org.ejercicio.calculadoradecalorias.dto.PlatoResponseDTO;
import org.ejercicio.calculadoradecalorias.entity.Ingrediente;
import org.ejercicio.calculadoradecalorias.repository.IIngredientesRepository;
import org.ejercicio.calculadoradecalorias.service.IPlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class PlatoServiceImpl implements IPlatoService {

    @Autowired
    IIngredientesRepository ingredientesRepository;

    @Override
    public PlatoResponseDTO informacionPlato(PlatoDTO platoDTO) {
        PlatoResponseDTO platoResponseDTO= new PlatoResponseDTO();
        platoResponseDTO.setNombre(platoDTO.getNombre());
        List<IngredienteDTO> ingredientes = new ArrayList<>();
        platoResponseDTO.setTotalCalorias(0);
        for(IngredienteDTO ingredienteDTO: platoDTO.getIngredienteDTOS()){
            Ingrediente ingrediente = ingredientesRepository.buscarPorNombre(ingredienteDTO.getNombre());
            if(ingrediente != null){

                double factorCaloria = (double) ingredienteDTO.getPeso() /100;
                double calculoCalorias = platoResponseDTO.getTotalCalorias()+
                        (factorCaloria*ingrediente.getCalories());
                ingredienteDTO.setCalorias(calculoCalorias);
                platoResponseDTO.setTotalCalorias(calculoCalorias);
                ingredientes.add(ingredienteDTO);

            }
        }
        platoResponseDTO.setIngredientes(ingredientes);

        platoResponseDTO.setIngredienteConMasCalorias(platoResponseDTO.getIngredientes().stream()
                .max(Comparator.comparing(IngredienteDTO::getCalorias)).orElse(null));

        return platoResponseDTO;
    }
}
