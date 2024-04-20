package com.asinc_ejerciciocalculadoracalorias.servicio.implementacion;

import com.asinc_ejerciciocalculadoracalorias.dto.IngredienteDTO;
import com.asinc_ejerciciocalculadoracalorias.dto.PlatoRequestDTO;
import com.asinc_ejerciciocalculadoracalorias.dto.PlatoResponseDTO;
import com.asinc_ejerciciocalculadoracalorias.entidad.Ingrediente;
import com.asinc_ejerciciocalculadoracalorias.entidad.Plato;
import com.asinc_ejerciciocalculadoracalorias.repositorio.Repositorio;
import com.asinc_ejerciciocalculadoracalorias.servicio.IPlatoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlatoService implements IPlatoServicio {

    @Override
    public PlatoResponseDTO calcularCalorias(PlatoRequestDTO plato) {
        //verifico que el plato recibido exista
        Plato platoRepo = Repositorio.listaPlatos
                .stream()
                .filter(p -> p.getNombre().equalsIgnoreCase(plato.getNombre()))
                .findFirst()
                .orElse(null);

        if (platoRepo != null) {
            PlatoResponseDTO platoResponse = new PlatoResponseDTO();
            platoResponse.setNombre(platoRepo.getNombre());

            double caloriasTotales = 0;
            String ingredienteCaloriasMax = "";
            double caloriasMax = 0;
            List<IngredienteDTO> listaIngredientesDTO = new ArrayList<>();

            for (Ingrediente ingrediente : platoRepo.getListaIngredientes()) {
                caloriasTotales += plato.getPeso() * ingrediente.getCalorias() / 100;

                if (ingrediente.getCalorias() > caloriasMax) {
                    caloriasMax = ingrediente.getCalorias();
                    ingredienteCaloriasMax = ingrediente.getNombre();
                }

                listaIngredientesDTO.add(new IngredienteDTO(ingrediente.getNombre(), ingrediente.getCalorias()));
            }
            platoResponse.setIngredienteMasCalorias(ingredienteCaloriasMax);
            platoResponse.setCantidadCaloriasTotal(caloriasTotales);
            platoResponse.setListaIngredientesDTO(listaIngredientesDTO);

            return platoResponse;
        }
        return null;
    }

    @Override
    public List<PlatoResponseDTO> calcularCalorias(List<PlatoRequestDTO> platos) {
        List<PlatoResponseDTO> listaPlatosResponseDTO = new ArrayList<>();

        for (PlatoRequestDTO platoRequestDTO : platos) {
            listaPlatosResponseDTO.add(calcularCalorias(platoRequestDTO));
        }
        return listaPlatosResponseDTO;
    }
}
