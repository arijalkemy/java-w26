package org.example;

public class Curriculum implements Iimprimible{
    private String nombre;
    private String profecion;
    private String habilidades;

    public Curriculum(String nombre, String profecion, String habilidades) {
        this.nombre = nombre;
        this.profecion = profecion;
        this.habilidades = habilidades;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProfecion() {
        return profecion;
    }

    public void setProfecion(String profecion) {
        this.profecion = profecion;
    }

    public String getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(String habilidades) {
        this.habilidades = habilidades;
    }


    @Override
    public void imprimiendo() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Nombre: " + profecion);
        System.out.println("Nombre: " + habilidades);
    }
}
