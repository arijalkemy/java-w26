package org.example.ejercicio_integrador_parte_1_y_2;

public class Client {
    private String dni;
    private String nombre;
    private String apellido;

    public Client() {}

    public Client(String dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
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
        return "Datos del Cliente - DNI: " + dni + ", Nombre: '" + nombre + ", Apellido: '" + apellido;
    }
}
