package org.example;

import java.util.*;

public class Curriculums implements IImprimible{

    String nombre;
    String apellido;
    int edad;
    List<String> habilidadades = new ArrayList<>();

    public Curriculums(String nombre, String apellido, int edad, List<String> habilidadades) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.habilidadades = habilidadades;
    }


    @Override
    public void imprimir() {
        System.out.println("nombre: " + getNombre() +
                            "\nApellido: " + getApellido() +
                            "\nEdad: "  + getEdad());

        for (String habilidad: habilidadades) {
            System.out.println("Habilidades: " + habilidad);

        }

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public List<String> getHabilidadades() {
        return habilidadades;
    }

    public void setHabilidadades(List<String> habilidadades) {
        this.habilidadades = habilidadades;
    }


}
