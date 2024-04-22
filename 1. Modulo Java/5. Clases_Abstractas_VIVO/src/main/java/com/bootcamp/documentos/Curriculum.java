package com.bootcamp.documentos;

public class Curriculum extends Documento {
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String[] habilidades;

    public Curriculum(String nombre, String apellido, String email, String telefono, String[] habilidades) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.habilidades = habilidades;
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimiendo Curriculum");
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Email: " + email);
        System.out.println("Telefono: " + telefono);
        System.out.println("Habilidades: ");
        for (String habilidad : habilidades) {
            System.out.println(habilidad);
        }

    }
}
