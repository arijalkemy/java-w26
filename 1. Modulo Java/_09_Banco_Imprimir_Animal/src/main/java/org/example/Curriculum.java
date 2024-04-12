package org.example;

import java.util.List;

public class Curriculum implements IImprimible{

    private String nombre;
    private String apellido;
    private int DNI;

    private List<String> habilidades;

    public Curriculum(String nombre, String apellido, int DNI, List<String> habilidades){
        this.nombre = nombre;
        this.apellido = apellido;
        this.DNI = DNI;
        this.habilidades = habilidades;
    }

    public void imprimir(){
        System.out.println("Nombre: " + this.nombre + ". Apellido: " + this.apellido + ". DNI: " + this.DNI + ". Habilidades: " + this.habilidades);
    }
}
