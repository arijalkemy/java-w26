package org.example.clases;

import org.example.interfaces.Documento;
import org.example.interfaces.Imprimible;

import java.util.List;

public class Curriculum implements Documento {
    private String nombre;
    private String apellido;
    private String cel;
    private String direccion;
    private List<String> habilidades;

    public Curriculum(String nombre, String apellido, String cel, String direccion, List<String> habilidades) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cel = cel;
        this.direccion = direccion;
        this.habilidades = habilidades;
    }

    @Override
    public void Imprimir() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", cel='" + cel + '\'' +
                ", direccion='" + direccion + '\'' +
                ", habilidades=" + habilidades +
                '}';
    }
}
