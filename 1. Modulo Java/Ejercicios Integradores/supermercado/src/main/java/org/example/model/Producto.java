package org.example.model;

public class Producto {
    private int codigo;
    private String nombre;
    private int cantidad;
    private Double costoUnitario;

    public Producto() {
    }

    public Producto(int codigo, String nombre, int cantidad, Double costoUnitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.costoUnitario = costoUnitario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(Double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    @Override
    public String toString() {
        return  "  Producto" + "\n" +
                "    Codigo: " + codigo +
                "    Nombre: " + nombre + "\n" +
                "    Cantidad: " + cantidad + "\n" +
                "    Costo Unitario: " + costoUnitario + "\n";
    }
}
