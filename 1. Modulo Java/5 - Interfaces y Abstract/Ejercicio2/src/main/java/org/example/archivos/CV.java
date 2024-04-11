package org.example.archivos;

import java.util.ArrayList;

public class CV {
    String nombre_archivo;
    ArrayList<String> habilidades;

    public CV(String nombre_archivo, ArrayList<String> habilidades) {
        this.nombre_archivo = nombre_archivo;
        this.habilidades = habilidades;
    }

    public String getNombre_archivo() {
        return nombre_archivo;
    }

    public void setNombre_archivo(String nombre_archivo) {
        this.nombre_archivo = nombre_archivo;
    }

    public ArrayList<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(ArrayList<String> habilidades) {
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        return "CV{" +
                "nombre_archivo='" + nombre_archivo + '\'' +
                ", habilidades=" + habilidades +
                '}';
    }
}
