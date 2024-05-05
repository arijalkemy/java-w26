package com.viajescuidados.repositories;

import com.viajescuidados.entities.Persona;
import com.viajescuidados.entities.ubicaciones.Ubicacion;
import com.viajescuidados.entities.viajes.EstadoViaje;
import com.viajescuidados.entities.viajes.Viaje;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Profile(value = "test")
public class ViajesRepositoryTest implements IViajesRepository {
    private List<Viaje> viajes;

    public ViajesRepositoryTest() {
        this.viajes  = new ArrayList<>();
        Persona thePersona = Persona.builder()
                .id(1)
                .nombre("Juan")
                .apellido("Manzanares")
                .build();
        Persona cuidadorOne = Persona.builder()
                .id(2)
                .nombre("Armando")
                .apellido("Casas")
                .build();
        Persona cuidadorTwo = Persona.builder()
                .id(3)
                .nombre("Anala")
                .apellido("Paty Netita")
                .build();
        Viaje newViaje = Viaje.builder()
                .id(1)
                .cuidadores(List.of(cuidadorOne, cuidadorTwo))
                .origen(new Ubicacion("Dir1", 22L, 23L))
                .destino(new Ubicacion("Dir2", 33L, 88L))
                .estado(EstadoViaje.EN_PROCESO)
                .duracionEstimadaEnMins(234L)
                .persona(thePersona)
                .build();
        this.guardar(newViaje);
    }

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
