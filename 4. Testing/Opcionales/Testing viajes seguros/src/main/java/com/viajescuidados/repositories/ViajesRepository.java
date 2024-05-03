package com.viajescuidados.repositories;

import com.viajescuidados.entities.viajes.Viaje;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ViajesRepository implements IViajesRepository {
    private List<Viaje> viajes = new ArrayList<>();

    @Override
    public void guardar(Viaje nuevoViaje) {
        this.viajes.add(nuevoViaje);
        nuevoViaje.setId(this.viajes.size());
    }

    @Override
    public Optional<Viaje> buscarPorId(Integer id) {
        return this.viajes.stream().filter(v -> v.getId().equals(id)).findFirst();
    }

    @Override
    public void modificar(Viaje viaje) {
        //do nothing
    }
}
