package org.example.ejercicio_2;

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

    public String contenido() {
        return "Nombre: " + nombre + ", Email: " + email + ", Habilidades: " + String.join(", ", habilidades);
    }
}
