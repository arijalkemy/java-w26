package org.example;

import java.util.ArrayList;
import java.util.List;

public class Curriculum implements Impresora{
    private Persona persona;
    private List<String> habilidades;

    public Curriculum(Persona persona, List<String> habilidades) {
        this.persona = persona;
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        return "Imprimiendo CV\n" +
        "de: " + persona.getNombre() + "\nquien tiene las siguientes habilidades: " + habilidades;
        //for (String habilidad: habilidades){

        //    System.out.println("imprimiedo habilidad " + habilidad);
        //}
    }

}
