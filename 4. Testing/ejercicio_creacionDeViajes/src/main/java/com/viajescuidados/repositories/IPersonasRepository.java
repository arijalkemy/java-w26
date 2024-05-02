package com.viajescuidados.repositories;

import com.viajescuidados.entities.Persona;

import java.util.List;
import java.util.Optional;

public interface IPersonasRepository {
    void guardar(Persona persona);
    void modificar(Persona persona);
    List<Persona> buscarTodos();
    Optional<Persona> buscarPorId(Integer id);
    void limpiarDatos();

}
