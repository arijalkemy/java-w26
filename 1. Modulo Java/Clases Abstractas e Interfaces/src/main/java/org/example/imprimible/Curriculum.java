package org.example.imprimible;

import java.util.List;

public class Curriculum implements Imprimible{
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
        System.out.println("Curriculum: " +
                "Nombre: " + nombre + " Email: " + email + " Habilidades: \n" +
                String.join(", ",habilidades));
    }
}
