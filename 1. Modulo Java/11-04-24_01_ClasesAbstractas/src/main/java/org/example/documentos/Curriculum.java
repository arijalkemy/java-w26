package org.example.documentos;
public class Curriculum implements Imprimible {
    private String nombre;
    private String apellido;
    private String[] habilidades;

    public Curriculum(String nombre, String apellido, String[] habilidades) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.habilidades = habilidades;
    }

    @Override
    public void imprimir() {
        System.out.println("Curriculum de " + nombre + " " + apellido);
        System.out.println("Habilidades: " + String.join(", ", habilidades));
    }
}