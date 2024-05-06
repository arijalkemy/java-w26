package com.viajescuidados.entities.viajes;

import com.viajescuidados.entities.Persona;
import com.viajescuidados.entities.ubicaciones.Ubicacion;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@EqualsAndHashCode
@Builder
public class Viaje {
    private Integer id;
    private Persona persona;
    private List<Persona> cuidadores = new ArrayList<>();
    private Ubicacion origen;
    private Ubicacion destino;
    private EstadoViaje estado;
    private Long duracionEstimadaEnMins;
    private LocalDateTime fechaComienzo;
    private LocalDateTime fechaFinalizacion;


    public void agregarCuidador(Persona persona) {
        this.cuidadores.add(persona);
    }
}
