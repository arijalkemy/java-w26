package org.example;

import java.util.List;

public class Curriculum implements Imprimible {
    private String nombre;
    private String direccion;
    private String email;
    private String numeroTelefono;
    private List<String> habilidades;

    public Curriculum(String nombre, String direccion, String email, String numeroTelefono, List<String> habilidades) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.email = email;
        this.numeroTelefono = numeroTelefono;
        this.habilidades = habilidades;
    }

    @Override
    public void imprimir() {
                 System.out.println("nombre: " + nombre);
                 System.out.println("direccion: " + direccion);
                 System.out.println("email: " + email);
                 System.out.println("numeroTelefono: " + numeroTelefono);
                 System.out.println("habilidades: " + habilidades);
    }
}
