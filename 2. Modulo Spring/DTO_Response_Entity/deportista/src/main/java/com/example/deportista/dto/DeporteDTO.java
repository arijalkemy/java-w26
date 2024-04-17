package com.example.deportista.dto;

import com.example.deportista.model.Deporte;
import com.example.deportista.repository.DeporteRepository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public class DeporteDTO implements Serializable {

    public DeporteDTO() {
    }

    public static List<Deporte> getDeportes() {
        return DeporteRepository.getDeportes();
    }

    public static String getNivel(String nombre) {
        Optional<Deporte> deporteOptional = DeporteRepository.getDeportes().stream().filter(d -> d.getNombre().equals(nombre)).findFirst();

        String nivel = deporteOptional.isPresent() ? deporteOptional.get().getNivel() : "";

        return nivel;
    }
}
