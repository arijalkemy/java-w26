package org.bootcamp.domain;

public class Cliente {

    private int dni;
    private String nombre;
    private String apellido;

    public Cliente() {
    }

    public Cliente(int dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("\n*** Cliente ***");
        sb.append("\ndni: ").append(dni);
        sb.append("\nnombre: ").append(nombre);
        sb.append("\napellido: ").append(apellido);
        return sb.toString();
    }
}
