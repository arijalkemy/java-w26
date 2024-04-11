package org.bootcamp.ejercicio2.interfaces.entidades;

import org.bootcamp.ejercicio2.interfaces.Documento;

import java.util.List;

public class Curriculum implements Documento {
    private String persona;
    private List<String> habilidades;

    public Curriculum(String persona, List<String> habilidades) {

        this.persona = persona;
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "La persona " + persona + '\'' +
                ", cuenta con las siguientes habilidades=" + habilidades.toString()+
                '}';
    }
}
