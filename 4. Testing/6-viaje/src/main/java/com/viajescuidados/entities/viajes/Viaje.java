package com.viajescuidados.entities.viajes;

import com.viajescuidados.entities.Persona;
import com.viajescuidados.entities.ubicaciones.Ubicacion;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Builder
@EqualsAndHashCode
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

    @Override
    public String toString() {
        return "Viaje{" +
                "id=" + id +
                ", persona=" + persona +
                ", cuidadores=" + cuidadores +
                ", origen=" + origen +
                ", destino=" + destino +
                ", estado=" + estado +
                ", duracionEstimadaEnMins=" + duracionEstimadaEnMins +
                ", fechaComienzo=" + fechaComienzo +
                ", fechaFinalizacion=" + fechaFinalizacion +
                '}';
    }

    public void agregarCuidador(Persona persona) {
        this.cuidadores.add(persona);
    }
}
