package org.example.calorias.service;

import org.example.calorias.dto.IngredienteConPesoDTO;
import org.example.calorias.dto.PlatoConPesoRequestDTO;
import org.example.calorias.dto.PlatoConPesoResponseDTO;
import org.example.calorias.dto.PlatoDTO;
import org.example.calorias.entity.Ingrediente;
import org.example.calorias.entity.Plato;
import org.example.calorias.repository.IPlatoRepository;
import org.example.calorias.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlatoServiceImpl implements IPlatoService {

    @Autowired
    private IPlatoRepository platoRepository;


    @Override
    public List<PlatoDTO> buscarTodos() {

        return platoRepository.buscarTodos().stream()
            .map(Mapper::toPlatoDTO)
            .toList();
    }

    @Override
    public Optional<PlatoConPesoResponseDTO> buscarPorNombreConPeso(String nombre, int peso) {

        return platoRepository.buscarPorNombre(nombre)
            .map(plato -> calcularPlatoConPeso(plato, peso));
    }

    @Override
    public List<PlatoConPesoResponseDTO> buscarEnLote(List<PlatoConPesoRequestDTO> platos) {

        return platos.stream()
            .flatMap(plato -> buscarPorNombreConPeso(plato.getNombre(), plato.getPeso()).stream())
            .toList();
    }


    private static PlatoConPesoResponseDTO calcularPlatoConPeso(Plato plato, int peso) {

        List<IngredienteConPesoDTO> ingredientesConPeso = plato.getIngredientes().stream()
            .map(ingrediente -> calcularIngredienteConPeso(ingrediente, peso))
            .toList();

        int caloriasPlato = ingredientesConPeso.stream().mapToInt(IngredienteConPesoDTO::getCalorias).sum();

        return new PlatoConPesoResponseDTO(
            plato.getNombre(),
            peso,
            caloriasPlato,
            ingredientesConPeso
        );
    }

    private static IngredienteConPesoDTO calcularIngredienteConPeso(Ingrediente ingrediente, int peso) {

        int calorias = ingrediente.getCaloriasPorCada100Gramos() * peso / 100;

        return new IngredienteConPesoDTO(
            ingrediente.getNombre(),
            ingrediente.getCaloriasPorCada100Gramos(),
            peso,
            calorias
        );
    }
}
