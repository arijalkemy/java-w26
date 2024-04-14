package org.example.classes;

public class Producto {
    private String nombre;
    private float costo;
    private TipoProducto tipoProducto;

    public Producto(String nombre, float costo, TipoProducto tipoProducto) {
        this.nombre = nombre;
        this.costo = costo;
        this.tipoProducto = tipoProducto;
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }
}
