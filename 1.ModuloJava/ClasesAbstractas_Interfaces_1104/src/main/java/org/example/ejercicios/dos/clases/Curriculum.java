package org.example.ejercicios.dos.clases;

import org.example.ejercicios.dos.Interfaces.Imprimible;

public class Curriculum implements Imprimible {
    private String persona;
    private String habilidades[];

    public Curriculum(String persona, String[] habilidades) {
        this.persona = persona;
        this.habilidades = habilidades;
    }

    @Override
    public void imprimir() {
    System.out.println("Nombre de la persona :" + this.persona);
        System.out.println("Habilidades:");
        for (String habilidad : this.habilidades) {
            System.out.println("__" + habilidad);
        }
    }

}
