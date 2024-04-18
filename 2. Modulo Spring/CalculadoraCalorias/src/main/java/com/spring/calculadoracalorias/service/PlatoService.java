package com.spring.calculadoracalorias.service;

import com.spring.calculadoracalorias.dto.PlatoDTO;
import com.spring.calculadoracalorias.dto.PlatoRequestDTO;
import com.spring.calculadoracalorias.entity.Ingrediente;
import com.spring.calculadoracalorias.entity.Plato;
import com.spring.calculadoracalorias.repository.IngredienteRepository;
import com.spring.calculadoracalorias.repository.PlatoRepository;
import com.spring.calculadoracalorias.service.interfaces.IPlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class PlatoService implements IPlatoService {


    @Override
    public List<PlatoDTO> getListOfPlatosByNameAndPeso(List<PlatoRequestDTO> platos) {

        List<Plato> listPlatos = PlatoRepository.getAllPlatos();
        List<PlatoDTO> lPDTO = new ArrayList<>();
        platos.stream().forEach(pd -> {
            listPlatos.stream()
                    .filter(p -> p.getName().contains(pd.getNombre()))
                    .findFirst()
                    .ifPresent(plato -> {
                        lPDTO.add(convertToDto(plato, pd.getPeso()));
                    });
        });

        return lPDTO;


    }

    @Override
    public PlatoDTO getPlatoByNameAndPeso(String name, double peso) {
        List<Plato> pla = PlatoRepository.getAllPlatos();
        Plato p = pla.stream().filter(pl -> pl.getName().toLowerCase().contains(name.toLowerCase())).findFirst().orElse(null);
        return convertToDto(p, peso);
    }


    public PlatoDTO convertToDto(Plato p, double peso) {
        System.out.println(p);
        PlatoDTO pDTO = new PlatoDTO();
        double calTot = p.getListIngredientes().stream().mapToDouble(i -> i.getCalories()).sum() * (peso / 100);
        String ingredienteMasCalorico = p.getListIngredientes().stream()
                .max(Comparator.comparing(Ingrediente::getCalories))
                .map(Ingrediente::getName)
                .orElse("No hay ingredientes");
        pDTO.setName(p.getName());
        pDTO.setCaloriasTotales(calTot);
        pDTO.setListIngredientes(p.getListIngredientes());
        pDTO.setIngredienteMasCalorico(ingredienteMasCalorico);
        return pDTO;
    }


}
