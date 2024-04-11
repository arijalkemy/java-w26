package com.company.classes;

import com.company.interfaces.Imprimible;

import java.util.List;

public class Curriculum implements Imprimible {

    private String nombre;
    private String email;
    private List<String> habilidades;

    public Curriculum(String nombre, String email, List<String> habilidades) {
        this.nombre = nombre;
        this.email = email;
        this.habilidades = habilidades;
    }

    @Override
    public void imprimir() {
        System.out.println("Curiculum");
        System.out.println(" - Nombre: " + nombre);
        System.out.println(" - email: " + habilidades);
        System.out.println(" - habilidades: ");
        for(String habilidad: habilidades) {
            System.out.println("   - " + habilidad);
        }

    }
}
