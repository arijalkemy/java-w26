package org.ggomezr;

public class Curriculum extends Documento implements Imprimible{
    private String nombre;
    private int edad;
    private String habilidades;

    public Curriculum(String nombre, int edad, String habilidades) {
        this.nombre = nombre;
        this.edad = edad;
        this.habilidades = habilidades;
        this.contenido = this.contenido = "Nombre: " + nombre + "\nEdad: " + edad + "\nHabilidades: " + habilidades;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(String habilidades) {
        this.habilidades = habilidades;
    }
}
