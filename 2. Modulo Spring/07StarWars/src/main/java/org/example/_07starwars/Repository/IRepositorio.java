package org.example._07starwars.Repository;

import org.example._07starwars.Model.Personaje;

import java.util.List;

public interface IRepositorio {
    public List<Personaje> buscarPorNombre(String nombre);
}
