package org.example.calorias.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.calorias.dto.PlatoJsonDTO;
import org.example.calorias.entity.Plato;
import org.example.calorias.util.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class PlatoRepositoryImpl implements IPlatoRepository {

    private final List<Plato> platos;

    public PlatoRepositoryImpl() {
        try {
            File jsonFile = ResourceUtils.getFile("classpath:static/food.json");

            PlatoJsonDTO[] platosArray = new ObjectMapper().readValue(jsonFile, PlatoJsonDTO[].class);

            platos = Arrays.stream(platosArray).map(Mapper::toPlato).toList();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<Plato> buscarTodos() {
        return platos;
    }

    @Override
    public Optional<Plato> buscarPorNombre(String nombre) {

        return platos.stream()
            .filter(p -> p.getNombre().toLowerCase().contains(nombre.toLowerCase()))
            .findFirst();
    }
}
