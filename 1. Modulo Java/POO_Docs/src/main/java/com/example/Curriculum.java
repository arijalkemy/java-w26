package com.example;

import java.util.List;

public class Curriculum implements Imprimible {

    private String nombre;
    private String apellido;
    private int edad;
    private String dni;
    private List<String> habilidades;


    public Curriculum(String nombre, String apellido, int edad, String dni, List<String> habilidades) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.dni = dni;
        this.habilidades = habilidades;
    }
    

    @Override
    public void imprimir() {
        System.out.printf("<< CURRICULUM %s %s>>%n" +
        "| edad: %d%n" +
        "| dni: %s%n",nombre,apellido,edad,dni);
    }
    
}
