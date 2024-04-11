package org.main.ejercicio2.clases;

import java.util.List;
import org.main.ejercicio2.interfaces.Documento;

public class Curriculum implements Documento {
    private String nombre;
    private String apellidos;
    private String direccion;
    private String telefono;
    private String email;
    private String experiencia;
    private String formacion;
    private List habilidades;

    public Curriculum(String nombre, String apellidos, String direccion, String telefono, String email, String experiencia, String formacion, List habilidades) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.experiencia = experiencia;
        this.formacion = formacion;
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", experiencia='" + experiencia + '\'' +
                ", formacion='" + formacion + '\'' +
                ", habilidades=" + habilidades +
                '}';
    }
}
