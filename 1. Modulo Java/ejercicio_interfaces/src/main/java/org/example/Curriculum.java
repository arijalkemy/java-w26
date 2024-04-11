package org.example;

import java.util.List;

public class Curriculum {

    private String personaNombre;
    private int edad;
    private List<String> habilidades;


    public Curriculum(String personaNombre, int edad, List<String> habilidades) {
        this.personaNombre = personaNombre;
        this.edad = edad;
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        String aux = "\n";
        for(String habilidad: habilidades){
            aux += "-" + habilidad + "\n";
        }
        return "CV\n" + "Nombre: " + this.personaNombre + "\nEdad: " + this.edad + "\nHabilidades: " + aux;
    }
}
