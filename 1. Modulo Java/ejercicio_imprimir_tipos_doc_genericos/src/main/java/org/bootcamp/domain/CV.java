package org.bootcamp.domain;

import java.util.List;

public class CV {

    private int dni;
    private String nombre;
    private String apellido;
    private List<String> habilidades;

    public CV() {
    }

    public CV(int dni, String nombre, String apellido, List<String> habilidades) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.habilidades = habilidades;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("\n\n--- CURRICULUM (CV) ----");
        sb.append("\ndni: ").append(dni);
        sb.append("\nnombre: ").append(nombre);
        sb.append("\napellido: ").append(apellido);
        sb.append("\nhabilidades: ").append(habilidades);
        return sb.toString();
    }
}
