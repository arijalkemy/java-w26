package com.example.starwars.repository;
import com.example.starwars.entity.Personaje;
import java.util.List;
public interface IRepositorio {
    public List<Personaje> obtenerPersonajes();
}
