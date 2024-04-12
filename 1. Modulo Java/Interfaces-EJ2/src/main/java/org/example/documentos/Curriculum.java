package org.example.documentos;

import org.example.interfaces.ImprimibleImpl;

public class Curriculum implements ImprimibleImpl {

    private String nombre;
    private String apellido;
    private int edad;
    private String habilidades;

    public Curriculum(String nombre, String apellido, int edad, String habilidades) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.habilidades = habilidades;
    }


    @Override
    public void imprimir() {
        System.out.println("Curriculum:");
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Edad: " + edad);
        System.out.println("Habilidades: " + habilidades);
    }
}
