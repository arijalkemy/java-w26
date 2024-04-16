package modelo;

import enums.RolTripulante;

public class Tripulante {

    private String nombre;

    private RolTripulante rolTripulante;

    public Tripulante(String nombre, RolTripulante rolTripulante) {
        this.nombre = nombre;
        this.rolTripulante = rolTripulante;
    }
}
