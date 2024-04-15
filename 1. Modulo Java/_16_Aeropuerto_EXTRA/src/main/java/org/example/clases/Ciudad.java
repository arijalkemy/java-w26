package org.example.clases;

import java.util.List;

public class Ciudad {
    private String nombre;
    private List<Aeropuerto> aeropuertos;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Aeropuerto> getAeropuertos() {
        return aeropuertos;
    }

    public void setAeropuertos(List<Aeropuerto> aeropuertos) {
        this.aeropuertos = aeropuertos;
    }

    public Ciudad() {
    }

    public Ciudad(String nombre, List<Aeropuerto> aeropuertos) {
        this.nombre = nombre;
        this.aeropuertos = aeropuertos;
    }
}
