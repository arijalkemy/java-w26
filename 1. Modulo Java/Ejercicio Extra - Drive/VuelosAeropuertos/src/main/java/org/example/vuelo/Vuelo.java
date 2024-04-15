package org.example.vuelo;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Vuelo {
    private Map<Integer, Escala> ruta;
    private LocalDateTime horaSalida;
    private LocalDateTime horaLlegada;

    public Vuelo(){
        this.ruta = new HashMap<Integer, Escala>();
        this.horaSalida = null;
        this.horaLlegada = null;
    }

    public Map<Integer, Escala> getRuta() {
        return ruta;
    }

    public void setRuta(Map<Integer, Escala> ruta) {
        this.ruta = ruta;
    }

    public LocalDateTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalDateTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    public LocalDateTime getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(LocalDateTime horaLlegada) {
        this.horaLlegada = horaLlegada;
    }
}
