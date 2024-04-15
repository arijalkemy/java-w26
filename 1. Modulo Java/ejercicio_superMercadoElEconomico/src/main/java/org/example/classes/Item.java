package org.example.classes;

public class Item {
    private String codigo;
    private String nombre;
    private float precio;
    private int cantidadComprada;

    public Item(String codigo, String nombre, float precio, int cantidadComprada) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadComprada = cantidadComprada;
    }

    public int getCantidadComprada() {
        return cantidadComprada;
    }

    public void setCantidadComprada(int cantidadComprada) {
        this.cantidadComprada = cantidadComprada;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "{" + " codigo: " + codigo +
                ", nombre: '" + nombre +
                ", precio: " + precio +
                ", cantidadComprada: " + cantidadComprada +
                '}';
    }
}
