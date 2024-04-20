package com.example.demo.repository;

import com.example.demo.model.Personaje;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IStarWarsRepository {
    List<Personaje> buscarPersonajesPorNombre(String nombre);
}
