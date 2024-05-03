package com.viajescuidados.entities.viajes;

import com.viajescuidados.entities.Persona;
import com.viajescuidados.entities.ubicaciones.Ubicacion;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Builder
@Setter
@Getter
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

    public Viaje(Integer id, Persona persona, List<Persona> cuidadores, Ubicacion origen, Ubicacion destino, EstadoViaje estadoViaje, Long duracionEstimada) {
        this.id = id;
        this.persona = persona;
        this.cuidadores = cuidadores;
        this.origen = origen;
        this.destino = destino;
        this.estado = estadoViaje;
        this.duracionEstimadaEnMins = duracionEstimada;
    }

    public void agregarCuidador(Persona persona) {
        this.cuidadores.add(persona);
    }
}
