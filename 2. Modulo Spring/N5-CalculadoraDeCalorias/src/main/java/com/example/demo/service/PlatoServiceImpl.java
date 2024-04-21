package com.example.demo.service;

import com.example.demo.dto.IngredienteDto;
import com.example.demo.dto.PlatoResponseDTO;
import com.example.demo.entity.Ingrediente;
import com.example.demo.entity.Plato;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repository.PlatoRepositoryImpl;
import com.example.demo.repository.IPlatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class PlatoServiceImpl implements IPlatoService {

    private final IPlatoRepository platoRepository;

    @Autowired
    public PlatoServiceImpl(PlatoRepositoryImpl platoRepository) {
        this.platoRepository = platoRepository;
    }

    @Override
    public PlatoResponseDTO obtenerDetallesPlato(String nombrePlato, double pesoGramos) {
        List<Plato> platos = platoRepository.obtenerPlatos();
        if(platos.isEmpty() || platos.stream().noneMatch(p -> p.getNombre().equals(nombrePlato))){
            throw new NotFoundException("No existe ese plato");
        }

        Plato plato = platos.stream().filter(p -> p.getNombre().equals(nombrePlato)).findFirst().get();
        PlatoResponseDTO platoResponseDTO = new PlatoResponseDTO();
        platoResponseDTO.setTotalCalorias(obtenerCalorias(plato, pesoGramos));
        platoResponseDTO.setIngredientes(obtenerIngredientes(plato));
        platoResponseDTO.setIngredienteConMasCalorias(obtenerIngredienteConMasCalorias(plato));

        return platoResponseDTO;
    }

    // Obtengo el total de calorias del plato, teniendo en cuenta el porcentaje presente de cada ingrediente
    // Asumo que la caloria cargada en cada ingrediente corresponde al equivalente de 100gr de ese ingrediente
    private double obtenerCalorias(Plato plato, double pesoGramos){
        Map<Ingrediente, Integer> ingredientes = plato.getIngredientes();
        double calorias = 0;

        for(Map.Entry<Ingrediente, Integer> ingrediente : ingredientes.entrySet()){
            calorias = calorias + (((pesoGramos * ingrediente.getValue()/100) * ingrediente.getKey().getCalorias())/100);
        }
        return calorias;
    }

    // Muestra los ingredientes con su respectiva caloria, sin su proporcion en el plato
    private List<IngredienteDto> obtenerIngredientes(Plato plato){
        Map<Ingrediente, Integer> ingredientes = plato.getIngredientes();
        List<IngredienteDto> ingredientesDtos = new ArrayList<>();

        for(Map.Entry<Ingrediente, Integer> ingrediente : ingredientes.entrySet()){
            IngredienteDto ingredienteDto = new IngredienteDto();
            ingredienteDto.setNombre(ingrediente.getKey().getNombre());
            ingredienteDto.setCalorias(ingrediente.getKey().getCalorias());
            ingredientesDtos.add(ingredienteDto);
        }
        return ingredientesDtos;
    }

    private IngredienteDto obtenerIngredienteConMasCalorias(Plato plato){
        Map<Ingrediente, Integer> ingredientes = plato.getIngredientes();
        IngredienteDto ingredienteDto = new IngredienteDto();
        ingredienteDto.setCalorias(ingredienteDto.getCalorias());

        for(Map.Entry<Ingrediente, Integer> ingrediente : ingredientes.entrySet()){
            if(ingrediente.getKey().getCalorias() > ingredienteDto.getCalorias()){
                ingredienteDto.setNombre(ingrediente.getKey().getNombre());
                ingredienteDto.setCalorias(ingrediente.getKey().getCalorias());

            }
        }
        return ingredienteDto;
    }
}
