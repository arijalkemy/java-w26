package org.example;

import java.util.Objects;

public class Categoria {
    private int id;
    private String nombre;
    private String descripcion;

    public Categoria(int id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public int montoAPagarPor(Participante participante) {
        if(participante.esMayor()) {
            if(Objects.equals(this.nombre, "Circuito chico")) {
                return 1500;
            } else if (Objects.equals(this.nombre, "Circuito medio")) {
                return 2300;
            } else {
                return 2800;
            }
        } else {
            if(Objects.equals(this.nombre, "Circuito chico")) {
                return 1300;
            } else if (Objects.equals(this.nombre, "Circuito medio")) {
                return 2000;
            }
        }

        return -1;
    }

    public boolean puedeInscribirse(Participante participante) {
        if (Objects.equals(this.nombre, "Circuito avanzado")) {
            return participante.esMayor();
        }
        return true;
    }
}

