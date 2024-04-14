package org.example;

import java.util.ArrayList;
import java.util.List;

public class Curriculum implements Impresora{

    private String nombre;
    private String dni;
    private String titulo;
    private List<String> habilidades = new ArrayList<>();

    public Curriculum(String nombre, String dni, String titulo, List<String> habilidades) {
        this.nombre = nombre;
        this.dni = dni;
        this.titulo = titulo;
        this.habilidades = habilidades;
    }

    @Override
    public void imprimir() {
        System.out.println("Nombre: " + nombre);
        System.out.println("DNI: " + dni);
        System.out.println("Titulo: " + titulo);
        System.out.println("Habilidades: ");
        for (String habilidad : habilidades) {
            System.out.println("\t " + habilidad);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }
}
