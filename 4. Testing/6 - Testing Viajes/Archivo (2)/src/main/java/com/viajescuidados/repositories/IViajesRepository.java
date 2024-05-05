package com.viajescuidados.repositories;

import com.viajescuidados.entities.viajes.Viaje;

import java.util.Optional;

public interface IViajesRepository {
    void guardar(Viaje nuevoViaje);

    Optional<Viaje> buscarPorId(Integer id);

    void modificar(Viaje viaje);
}
