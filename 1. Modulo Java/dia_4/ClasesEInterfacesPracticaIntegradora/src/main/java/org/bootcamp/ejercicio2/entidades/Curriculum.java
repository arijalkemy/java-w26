package org.bootcamp.ejercicio2.entidades;

import java.util.List;

public class Curriculum extends Documento {
    private String persona;
    private List<String> habilidades;

    public Curriculum(String persona, List<String> habilidades) {
        this.persona = persona;
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "persona='" + persona + '\'' +
                ", habilidades=" + habilidades +
                '}';
    }

    @Override
    public void imprimirDocumento() {
        System.out.println(toString());
    }
}
