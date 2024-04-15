package org.example;

public class Cliente {
    private String nombre;
    private String apellido;
    private String dni;
    private int descuento = 0;
    private int cantidad = 0;

    public Cliente() {
    }

    public Cliente(String nome, String apellido, String dni) {
        this.nombre = nome;
        this.apellido = apellido;
        this.dni = dni;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad() {
        this.cantidad = cantidad + 1;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }
}
